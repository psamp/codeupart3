package com.psamp.multiplethreads;

class Follower implements Runnable {
	
	private Dribble dribble;

	public Follower(Dribble dribble) {
		this.dribble = dribble;
		new Thread(this, "Follower").start();
	}

	@Override
	public void run() {
		
		
		while(true) {
			System.out.println("Follower.run() | " + Thread.currentThread().getName());
			dribble.read();
		}
		
	}
	
	

}
