package com.psamp.multiplethreads;

import java.util.UUID;

class Author implements Runnable {

	private Dribble dribble;

	public Author(Dribble dribble) {
		this.dribble = dribble;
		new Thread(this, "Author").start();
	}

	@Override
	public void run() {
		int i = 0;

		while (i < 100) {
			i++;

			System.out.println("Producer.run() | " + Thread.currentThread().getName());
			dribble.post(UUID.randomUUID().toString());
		}
	}

}
