package com.aprendiendokotlin.laboratorio4;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderiza extends GLSurfaceView implements GLSurfaceView.Renderer {
    /* Objeto */
    private Cubo cubo;
    private CuboConst cuboCafe;
    private CuboConst cuboVerde;
    private CuboConst cuboAzul;
    private CuboConst cuboMulticolor;
    private Plano plano;

    private ColoresR coloresR = new ColoresR();

    private Triangulo triangulo;
    /* Ancho y alto de la ventana */
    private int ancho, alto;
    /* Para la rotación */
    private ArcBall arcBall = new ArcBall(640.0f, 480.0f);
    private float[] MatrizRotacion = new float[16];
    private float[] B = new float[16];

    public Renderiza(Context contexto) {
        super(contexto);
        /* Inicia el renderizado */
        this.setRenderer(this);
        /* La ventana solicita recibir una entrada */
        this.requestFocus();

        /* Establece que la ventana detecte el modo táctil */
        this.setFocusableInTouchMode(true);
        /* Se renderizará al inicio o cuando se llame a requestRender() */
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        cubo = new Cubo();
        triangulo = new Triangulo();
        plano = new Plano();
        cuboMulticolor = new CuboConst(coloresR.colorAmarillo);
        cuboVerde = new CuboConst(coloresR.colorVerde);
        cuboCafe = new CuboConst(coloresR.colorCafe);
        cuboAzul = new CuboConst(coloresR.colorAzul);

        /* B = I */
        Matriz4.identidad(B);
        /* Deshabilita dithering, no se limita la paleta de colores */
        gl.glDisable(GL10.GL_DITHER);

        /* Habilita el modo de sombreado Plano */
        gl.glShadeModel(GL10.GL_FLAT);

        /* Habilita el ocultamiento de superficies */
        gl.glEnable(GL10.GL_DEPTH_TEST);

        /* Limpia el buffer de profundidad con el valor de 1.0 */
        gl.glClearDepthf(1.0f);

        /* Acepta si valor Z de entrada es igual al valor Z del buffer de profundidad */
        gl.glDepthFunc(GL10.GL_LEQUAL);

        /* Color de fondo */
        gl.glClearColor(0, 0, 0, 0);
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        /* Incializa el buffer de color y de profundidad */
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        /* Inicializa la Matriz del Modelo-Vista */
        gl.glLoadIdentity(); // MVM = I

        gl.glPushMatrix();
        gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
        gl.glTranslatef(0, 2.0f, 0);
        //triangulo.dibuja(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
        gl.glTranslatef(0, -1.0f, 0);
        plano.dibuja(gl);
        gl.glPopMatrix();

        dibujaedificio(cuboCafe,gl, 7, 2, -5,4,4,4);

        dibujaedificio(cuboVerde,gl, 5, 3, 5,3.5f,3.5f,3.5f);

        //dibujaedificio(cuboCafe,gl, 2, 1, 3,2.5f,2.5f,2.5f);

        dibujaedificio(cuboAzul,gl, 4, 3, 9,3.5f,2.5f,1.5f);

        dibujaedificio(cuboAzul,gl, 5, 4, 1,2.5f,2.5f,2.5f);

        dibujaedificio(cuboVerde,gl, -3, 3, 1,4.5f,4.5f,4.5f);
        dibujaedificio(cuboCafe,gl, -3, 3, 8,5.5f,4.5f,4.5f);
        dibujaedificio(cuboAzul,gl, -3, 3, -6,6.5f,4.5f,4.5f);

        dibujaedificio(cuboCafe,gl, -9, 3, -4,2.5f,2.5f,2.5f);
        dibujaedificio(cuboVerde,gl, -9, 2, 1,2.5f,2.5f,2.5f);
        dibujaedificio(cuboAzul,gl, -9, 7, 5,3,3,3);
        dibujaedificio(cuboVerde,gl, -9, 9, 9,3,3,3);

        dibujaedificio(cuboCafe,gl, 9, 3, -4,2.5f,2.5f,2.5f);
        dibujaedificio(cuboVerde,gl, 9, 2, 1,2.5f,2.5f,2.5f);
        dibujaedificio(cuboAzul,gl, 9, 7, 5,3,3,3);
        dibujaedificio(cuboVerde,gl, 9, 9, 9,3,3,3);

        //dibujaArbol(gl, 9, 9, -9,3,3,3);


        gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
        //gl.glScalef(3,3,3);
       // cubo.dibuja(gl); // P' = MVM * P
    }

    private void dibujaArbol(GL10 gl, int corx, int cory, int corz, float x, float y, float z) {

        // Tronco
        for (int i = -1; i <= cory; i++) {
            gl.glPushMatrix();
            gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
            gl.glTranslatef(corx, i, corz);
            //gl.glScalef(x,y,z);
            cuboCafe.dibuja(gl);
            gl.glPopMatrix();
        }

        // Copa arbol
        for (int i = corx - 1; i < corx + 3; i++) {
            for (int j = cory + 1; j < (cory + 1) + 2; j++) {
                for (int u = corz - 1; u < corz + 2; u++) {
                    gl.glPushMatrix();
                    gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
                    gl.glTranslatef(i, j, u);
                    cuboVerde.dibuja(gl);
                    gl.glPopMatrix();
                }
            }

        }
    }

    private void dibujaedificio(CuboConst cubo,GL10 gl, int corx, int cory, int corz, float x, float y, float z) {

        // Tronco
        for (int i = -1; i <= cory; i++) {
            gl.glPushMatrix();
            gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
            gl.glTranslatef(corx, i, corz);
            gl.glScalef(x,y,z);
            cubo.dibuja(gl);
            gl.glPopMatrix();
        }

        // Copa arbol
        /*for (int i = corx - 1; i < corx + 3; i++) {
            for (int j = cory + 1; j < (cory + 1) + 2; j++) {
                for (int u = corz - 1; u < corz + 2; u++) {
                    gl.glPushMatrix();
                    gl.glMultMatrixf(MatrizRotacion, 0); // MVM = MVM * MatrizRotacion
                    gl.glTranslatef(i, j, u);
                    cuboVerde.dibuja(gl);
                    gl.glPopMatrix();
                }
            }

        }*/
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        ancho = w;
        alto = h;
        /* Ventana de despliegue */
        gl.glViewport(0, 0, ancho, alto);
        /* Matriz de Proyección */
        gl.glMatrixMode(GL10.GL_PROJECTION);
        /* Inicializa la Matriz de Proyección */
        gl.glLoadIdentity();
        /* Proyección paralela */
        if (w <= h)
            gl.glOrthof(-14, 14, -14 * (float) h / (float) w, 14 * (float) h / (float) w, -16, 16);
        else
            gl.glOrthof(-14 * (float) w / (float) h, 14 * (float) w / (float) h, -14, 14, -16, 16);
        /* Matriz del Modelo-Vista */
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        /* Inicializa la Matriz del Modelo-Vista */
        gl.glLoadIdentity();
        Matriz4.identidad(MatrizRotacion);
        /* Ajusta el ancho a [-1..1] y el alto a [-1..1] */
        arcBall.ajusta(ancho, alto);
    }

    /**
     * Maneja los eventos del movimiento en la pantalla táctil.
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /* B = MatrizRotacion */
                Matriz4.copia(B, MatrizRotacion);
                arcBall.primerPunto(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                /* Actualiza el segundo vector y obtiene el cuaternión */
                Cuaternion q = arcBall.segundoPunto(x, y);

                /* Convierte el cuaternión a una matriz de rotación */
                Cuaternion.rota(MatrizRotacion, q);

                /* MatrizRotacion = MatrizRotacion * B */
                Matriz4.multiplica(MatrizRotacion, MatrizRotacion, B);
                requestRender();
        }
        return true;
    }
}