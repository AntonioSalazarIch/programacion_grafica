package com.example.laboratorio3juego2d;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;
import android.widget.Toast;

public class Renderiza extends GLSurfaceView implements GLSurfaceView.Renderer
{
    private EndGame win;

    private int touchDer = 0;
    private int touchIzq = 0;
    private int naves= 0;
    private int navesLimite = 6;
    private int choque= 0;
    private int ancho;
    private int alto;
    private int contDer = 0;
    private int contIzq = 8;
    private Context context;
    //objeto
    private RectanguloGrafico r1_g,r2_g,r3_g,r4_g,r5_g,r6_g,r7_g,r8_g,r9_g,r10;
    private Rectangulo r1,r2,r3,r4,r5,r6,r7,r8,r9;
    /* Desplazamientos e Incrementos */
    private float x_r1 = -4, y_r1 = -5;
    private float x_r2 = -2, y_r2 = -2.5f, y_r2_aux=-4;
    private float x_r3 = -2, y_r3 = 3;
    private float x_r4 = -2, y_r4 = 0;
    private float x_r5 = (int) (Math.random() * 6), y_r5 = 0;
    private float x_r6 = (int) (Math.random() * 6), y_r6 = 0;
    private float x_r7 = (int) (Math.random() * 6), y_r7 = 0;
    private float x_r8 = (int) (Math.random() * 6), y_r8 = 0;
    private float x_r9 = (int) (Math.random() * 6), y_r9 = 0;
    private float x_r10 = (int) (Math.random() * 6), y_r10 = 0;

    //variables de control
    private int enemigo3 = 0;
    private int enemigo4 = 0;
    private int enemigo5 = 0;
    private int enemigo6 = 0;
    private int enemigo7 = 0;
    private int enemigo8 = 0;
    private int enemigo9 = 0;

    private float xVelocidad_r1 =  0.5f, yVelocidad_r1 = 0;
    private float xVelocidad_r2 =  0, yVelocidad_r2 = 0.5f;
    private float xVelocidad_r3 =  (float) (Math.random() * 0.02f), yVelocidad_r3 = (float) (Math.random() * 0.02f);
    private float xVelocidad_r4 =  (float) (Math.random() * 0.02f), yVelocidad_r4 = (float) (Math.random() * 0.02f);
    private float xVelocidad_r5 =  (float) (Math.random() * 0.02f), yVelocidad_r5 = (float) (Math.random() * 0.02f);
    private float xVelocidad_r6 =  (float) (Math.random() * 0.02f), yVelocidad_r6 = (float) (Math.random() * 0.02f);
    private float xVelocidad_r7 =  (float) (Math.random() * 0.02f), yVelocidad_r7 = (float) (Math.random() * 0.02f);
    private float xVelocidad_r8 =  (float) (Math.random() * 0.02f), yVelocidad_r8 = (float) (Math.random() * 0.02f);

    public Renderiza(Context context) {
        super(context);
        this.context = context;
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1)
    {
        win = new EndGame();

        r1_g = new RectanguloGrafico(0, 0, 1, 1);
        r1 = new Rectangulo(0, 0, 1, 1);

        r2_g = new RectanguloGrafico(0, 0, 0.05f, 0.5f);
        r2 = new Rectangulo(0, 0, 0.05f, 0.5f);

        r3_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r3 = new Rectangulo(0, 0, 0.5f, 0.5f);

        r4_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r4 = new Rectangulo(0, 0, 0.5f, 0.5f);

        r5_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r5 = new Rectangulo(0, 0, 0.5f, 0.5f);

        r6_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r6 = new Rectangulo(0, 0, 0.5f, 0.5f);

        r7_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r7 = new Rectangulo(0, 0, 0.5f, 0.5f);

        r8_g = new RectanguloGrafico(0, 0, 0.5f, 0.5f);
        r8 = new Rectangulo(0, 0, 0.5f, 0.5f);
        gl.glClearColor(0, 0, 0, 0);
    }

    public void dibujaRectangulo1(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r1, y_r1, 0);
        r1.x = x_r1;
        r1.y = y_r1;
        gl.glColor4f(1, 0, 0, 1);
        r1_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo2(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r2, y_r2, 0);
        r2.x = x_r2;
        r2.y = y_r2;
        gl.glColor4f(0, 1, 0, 1);
        r2_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo3(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r3, y_r3, 0);
        r3.x = x_r3;
        r3.y = y_r3;
        gl.glColor4f(0, 0, 1, 1);
        r3_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo4(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r4, y_r4, 0);
        r4.x = x_r4;
        r4.y = y_r4;
        gl.glColor4f(1, 0, 0, 1);
        r4_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo5(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r5, y_r5, 0);
        r5.x = x_r5;
        r5.y = y_r5;
        gl.glColor4f(0, 1, 0, 1);
        r5_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo6(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r6, y_r6, 0);
        r6.x = x_r6;
        r6.y = y_r6;
        gl.glColor4f(1, 0, 1, 1);
        r6_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo7(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r7, y_r7, 0);
        r7.x = x_r7;
        r7.y = y_r7;
        gl.glColor4f(0, 1, 1, 1);
        r7_g.dibuja(gl);
        gl.glPopMatrix();
    }

    public void dibujaRectangulo8(GL10 gl){
        gl.glPushMatrix();
        gl.glTranslatef(x_r8, y_r8, 0);
        r8.x = x_r8;
        r8.y = y_r8;
        gl.glColor4f(1, 1, 0, 1);
        r8_g.dibuja(gl);
        gl.glPopMatrix();
    }
    public void onDrawFrame(GL10 gl)
    {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        //avion
        if(touchDer == 0 && touchIzq == 0 && naves < 3 && choque == 0)
        {
            dibujaRectangulo1(gl);
        }

       if(touchDer == 1 && contDer < 14 && naves < 3 && choque == 0)
       {
           dibujaRectangulo1(gl);
       }
        if(touchIzq == 1 && contIzq < 14 && naves < 3 && choque == 0)
        {
            dibujaRectangulo1(gl);
        }


        //balas
        y_r2 = y_r2 + yVelocidad_r2;
        if (y_r2 >6) // izq y der
        {
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
        }
        if(naves < 3 && choque == 0)
        {
            dibujaRectangulo2(gl);
        }

        //enemigo 3
        x_r3 = x_r3 + xVelocidad_r3;
        if (x_r3 < -4 || x_r3 >4) // izq y der
            xVelocidad_r3 = -xVelocidad_r3;
        y_r3 = y_r3 + yVelocidad_r3;
        if (y_r3 < -6 || y_r3 > 5) // arriba y abajo
            yVelocidad_r3 = -yVelocidad_r3;
        //enemigo 4
        x_r4 = x_r4 + xVelocidad_r4;
        if (x_r4 < -4 || x_r4 >4) // izq y der
            xVelocidad_r4 = -xVelocidad_r4;
        y_r4 = y_r4 + yVelocidad_r4;
        if (y_r4 < -6 || y_r4 > 5) // arriba y abajo
            yVelocidad_r4 = -yVelocidad_r4;
        //enemigo 5
        x_r5 = x_r5 + xVelocidad_r5;
        if (x_r5 < -4 || x_r5 >4) // izq y der
            xVelocidad_r5 = -xVelocidad_r5;
        y_r5 = y_r5 + yVelocidad_r5;
        if (y_r5 < -6 || y_r5 > 5) // arriba y abajo
            yVelocidad_r5 = -yVelocidad_r5;

        //enemigo 6
        x_r6 = x_r6 + xVelocidad_r6;
        if (x_r6 < -4 || x_r6 >4) // izq y der
            xVelocidad_r6 = -xVelocidad_r6;
        y_r6 = y_r6 + yVelocidad_r6;
        if (y_r6 < -6 || y_r6 > 5) // arriba y abajo
            yVelocidad_r6 = -yVelocidad_r6;

        //enemigo 7
        x_r7 = x_r7 + xVelocidad_r7;
        if (x_r7 < -4 || x_r7 >4) // izq y der
            xVelocidad_r7 = -xVelocidad_r7;
        y_r7 = y_r7 + yVelocidad_r7;
        if (y_r7 < -6 || y_r7 > 5) // arriba y abajo
            yVelocidad_r7 = -yVelocidad_r7;

        //enemigo 8
        x_r8 = x_r8 + xVelocidad_r8;
        if (x_r8 < -4 || x_r8 >4) // izq y der
            xVelocidad_r8 = -xVelocidad_r8;
        y_r8 = y_r8 + yVelocidad_r8;
        if (y_r8 < -6 || y_r8 > 5) // arriba y abajo
            yVelocidad_r8 = -yVelocidad_r8;

        if (seSobreponen(r2, r3) && naves < navesLimite && choque == 0)
        {
            //xVelocidad_r2 = -xVelocidad_r1;
            r3.x = 4;
            r3.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo3 = 1;
            naves = naves + 1;
        }

        if(enemigo3 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo3(gl);
        }

        if (seSobreponen(r2, r4) && naves < navesLimite)
        {
            r4.x = 4;
            r4.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo4 = 1;
            naves = naves + 1;
        }

        if(enemigo4 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo4(gl);
        }
        //enemigo5
        if (seSobreponen(r2, r5) && naves < navesLimite)
        {
            //xVelocidad_r2 = -xVelocidad_r1;
            r5.x = 4;
            r5.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo5 = 1;
            naves = naves + 1;
        }

        if(enemigo5 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo5(gl);
        }

        //enemigo6
        if (seSobreponen(r2, r6) && naves < navesLimite)
        {
            //xVelocidad_r2 = -xVelocidad_r1;
            r6.x = 4;
            r6.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo6 = 1;
            naves = naves + 1;
        }

        if(enemigo6 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo6(gl);
        }

        //enemigo7
        if (seSobreponen(r2, r7) && naves < navesLimite)
        {
            //xVelocidad_r2 = -xVelocidad_r1;
            r7.x = 4;
            r7.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo7 = 1;
            naves = naves + 1;
        }

        if(enemigo7 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo7(gl);
        }

        //enemigo8
        if (seSobreponen(r2, r8) && naves < navesLimite)
        {
            //xVelocidad_r2 = -xVelocidad_r1;
            r8.x = 4;
            r8.y = 6;
            y_r2 = y_r1+0.5f;
            x_r2 = x_r1+1;
            enemigo8 = 1;
            naves = naves + 1;
        }

        if(enemigo8 == 0 && naves < navesLimite && choque == 0)
        {
            dibujaRectangulo8(gl);
        }

        if(naves == navesLimite )
        {
            win.dibuja(gl);
        }

        if (seSobreponen(r1, r3) && naves < navesLimite && choque == 0)
        {
            choque = 1;
        }
        if (seSobreponen(r1, r4) && naves < navesLimite && choque == 0)
        {
            choque = 1;
        }
        if (seSobreponen(r1, r5) && naves < navesLimite && choque == 0)
        {
            choque = 1;
        }

        if(choque == 1)
        {
            win.dibuja2(gl);
        }
        gl.glFlush();
    }

    public void onSurfaceChanged(GL10 gl, int w, int h)
    {
        ancho = w;
        alto = h;
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluOrtho2D(gl, -4, 4, -6, 6);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        float posx = e.getX();
        float posy = e.getY();
        if(e.getAction() == MotionEvent.ACTION_UP)//definimos el tipo de accion o evento que queremos usar
        {
            posx = ((posx / (float) ancho) * 8) - 4;
            posy = ((1 - posy / (float) alto) * 12) - 6;

            if (puntoEstaDentro(posx, posy, -4, -6, 2, 2) && contIzq < 8)
            {
                contDer = contDer - 1;
                contIzq = contIzq + 1;
                x_r1 = x_r1 - xVelocidad_r1;
                requestRender();
            } else
                {
                    if (puntoEstaDentro(posx, posy, 2, -6, 2, 2) && contDer < 13)
                    {
                        touchDer = 1;
                        contDer = contDer + 1;
                        contIzq = contIzq - 1;
                        x_r1 = x_r1 + xVelocidad_r1;
                        requestRender();
                    }
                }
            requestRender();
        }
        return true;
    }
    public boolean seSobreponen(Rectangulo r1, Rectangulo r2)
    {
        return (r1.x < r2.x + r2.ancho && r1.x + r1.ancho >  r2.x  &&
                r1.y < r2.y + r2.alto && r1.y	+ r1.alto > r2.y);
    }

    private boolean puntoEstaDentro(float posx, float posy, int x, int y, int ancho, int alto)
    {
        return (x < posx && posx < x + ancho &&
                y < posy && posy < y + alto);
    }
}
