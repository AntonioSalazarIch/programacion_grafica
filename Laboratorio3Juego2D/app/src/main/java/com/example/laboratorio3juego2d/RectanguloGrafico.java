package com.example.laboratorio3juego2d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class RectanguloGrafico {
	
	/* Coordenadas cartesianas (x, y) */
	private float vertices[] = new float [8];

	/* Indices */
	private short indices[] = new short []
			{
		 0, 1, 2, 0, 2, 3,
	};
	
	FloatBuffer bufVertices;
	ShortBuffer bufIndices;
	
	public RectanguloGrafico(float x1, float y1, float ancho, float alto)
	{
		
		float x2 = x1 + ancho;
		float y2 = y1 + alto;
		
		vertices[0] = x1; vertices[1] = y1;
		vertices[2] = x2; vertices[3] = y1;
		vertices[4] = x2; vertices[5] = y2;
		vertices[6] = x1; vertices[7] = y2;
		
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufVertices = bufByte.asFloatBuffer();
		bufVertices.put(vertices).rewind();

		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder());
		bufIndices = bufByte.asShortBuffer();
		bufIndices.put(indices).rewind();
	}
	
	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
