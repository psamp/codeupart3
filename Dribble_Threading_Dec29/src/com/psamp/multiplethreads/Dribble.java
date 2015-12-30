package com.psamp.multiplethreads;

import java.util.Date;

class Dribble {
	private String message;
	private boolean posted;

	synchronized void read() {
		System.out.println("Dribble.read() | posted = " + posted);

		while (!posted) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Dribble.read() | " + message + " read at" + new Date().toString());
		posted = false;

		notify();

	}

	synchronized void post(String msg) {
		System.out.println("Dribble.post() | posted = " + posted);

		while (posted) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("In Dribble.post()");
				e.printStackTrace();
			}

		}

		this.message = msg;
		posted = true;

		System.out.println("Dribble.post() | " + message + " posted at" + new Date().toString());
		notify();

	}

}
