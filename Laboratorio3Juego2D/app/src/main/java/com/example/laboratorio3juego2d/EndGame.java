package com.example.laboratorio3juego2d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class EndGame
{
    private float vertices[] = new float [] {
            -2.5f,       3,      // 0
               -2,    0.5f,      // 1
               -1,    1.5f,     // 2
                0,    0.5f,      //3
             0.5f,       3,      //4

            1.5f,3,
            1.5f,0.5f,

            2,0.5f,
            2,3,
            3.5f,0.5f,
            3.5f,3,

            -2,-0.5f,
            -2,-2.5f,
            -1,-2.5f,

            -0.5f,-1,
            -0.5f,-2.5f,
            0.5f,-2.5f,
            0.5f,-1,
            -0.5f,-1,

            2,-1,
            1,-1,
            1,-1.5f,
            2,-1.5f,
            2,-2.5f,
            1,-2.5f,

            3.5f,-1,
            2.5f,-1,
            2.5f,-1.5f,
            3.5f,-1.5f,
            3.5f,-2.5f,
            2.5f,-2.5f,

    };
    FloatBuffer bufVertices;
    public EndGame() {
        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer
    }

    public void dibuja(GL10 gl) {
        /* Se habilita el acceso al arreglo de vértices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* Se especifica los datos del arreglo de vértices */
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glColor4f(0, 1, 0, 0);
        gl.glDrawArrays(GL10.GL_LINES, 0, 2);
        gl.glDrawArrays(GL10.GL_LINES, 1, 2);
        gl.glDrawArrays(GL10.GL_LINES, 2, 2);
        gl.glDrawArrays(GL10.GL_LINES, 3, 2);

        gl.glDrawArrays(GL10.GL_LINES, 5, 2);

        gl.glDrawArrays(GL10.GL_LINES, 7, 2);
        gl.glDrawArrays(GL10.GL_LINES, 8, 2);
        gl.glDrawArrays(GL10.GL_LINES, 9, 2);



        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    public void dibuja2(GL10 gl) {
        /* Se habilita el acceso al arreglo de vértices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* Se especifica los datos del arreglo de vértices */
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glColor4f(0, 1, 0, 0);
        gl.glDrawArrays(GL10.GL_LINES, 11, 2);
        gl.glDrawArrays(GL10.GL_LINES, 12, 2);

        gl.glDrawArrays(GL10.GL_LINES, 14, 2);
        gl.glDrawArrays(GL10.GL_LINES, 15, 2);
        gl.glDrawArrays(GL10.GL_LINES, 16, 2);
        gl.glDrawArrays(GL10.GL_LINES, 17, 2);

        gl.glDrawArrays(GL10.GL_LINES, 19, 2);
        gl.glDrawArrays(GL10.GL_LINES, 20, 2);
        gl.glDrawArrays(GL10.GL_LINES, 21, 2);
        gl.glDrawArrays(GL10.GL_LINES, 22, 2);
        gl.glDrawArrays(GL10.GL_LINES, 23, 2);

        gl.glDrawArrays(GL10.GL_LINES, 25, 2);
        gl.glDrawArrays(GL10.GL_LINES, 26, 2);
        gl.glDrawArrays(GL10.GL_LINES, 27, 2);
        gl.glDrawArrays(GL10.GL_LINES, 28, 2);
        gl.glDrawArrays(GL10.GL_LINES, 29, 2);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }


}
