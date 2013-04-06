package com.neodem.sandbox.ddd.book.examples;

import java.awt.Graphics;
import java.io.InputStream;
import java.net.URL;

import com.neodem.graphics.dd.engine.applet.NoFlickerApplet;
import com.neodem.graphics.ddd.engine.book.Camera.GenericCamera;
import com.neodem.graphics.ddd.engine.book.Polyhedron.AbstractPolyhedron;
import com.neodem.graphics.ddd.engine.book.Polyhedron.ConvexPolyhedron;
import com.neodem.graphics.ddd.engine.book.Polyhedron.PolyhedronInstance;
import com.neodem.graphics.ddd.engine.book.structures.Angle3d;
import com.neodem.graphics.ddd.engine.book.structures.Point3d;

/**
 * A rotating cubes applet .. putting the classes to work with a quick and dirty
 * applet.
 */
public class Cube extends NoFlickerApplet implements Runnable {

	private static final long serialVersionUID = 1L;
	GenericCamera camera;
	Point3d CamPos;
	Angle3d CamAngle;

	AbstractPolyhedron cube;
	PolyhedronInstance cubeInstance[];
	Point3d pos[];
	Angle3d agl;

	Thread thread;

	/**
	 * initiate the applet.
	 */
	public void init() {
		// --
		// -- create a camera
		// --
		camera = new GenericCamera(400, 400, Math.PI / 2);
		CamPos = new Point3d(0, 0, 5);
		CamAngle = new Angle3d();

		// --
		// -- load a model from the file cube.f3d
		// --
		try {
			InputStream is = new URL(getCodeBase(), "cube.f3d").openStream();
			cube = new ConvexPolyhedron(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// -- create 9 instances of the cube
		cubeInstance = new PolyhedronInstance[9];
		for (int n = 0; n < 9; n++) {
			cubeInstance[n] = new PolyhedronInstance(cube);
		}

		// --
		// -- create the positions and angle
		// --
		pos = new Point3d[9];
		int n = 0;
		for (int y = -5; y <= 5; y += 5) {
			for (int x = -5; x <= 5; x += 5) {
				pos[n] = new Point3d(x, y, 0);
				n++;
			}
		}
		agl = new Angle3d();

		start();

	}

	public void run() {

		Thread thisThread = Thread.currentThread();
		while (thread == thisThread) {
			try {
				thisThread.sleep(100);
			} catch (InterruptedException e) {
			}

			agl.x += Math.PI / 20;
			agl.y += Math.PI / 30;

			// --
			// -- update camera angle and position
			// --
			CamPos.z += 0.2;
			CamAngle.z += Math.PI / 50;
			camera.setOrientation(CamPos, CamAngle);

			repaint();
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		thread = null;
	}

	public void paint(Graphics g) {
		// -- clear screen
		g.clearRect(0, 0, getSize().width, getSize().height);

		// --
		// -- paint the models
		// --
		for (int n = 0; n < 9; n++) {
			cubeInstance[n].setOrientation(pos[n], agl);
			cubeInstance[n].paint(g, camera);
		}
	}
}
