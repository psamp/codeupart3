package com.psamp.multiplethreads;

class Dribble_Start {

	public static void main(String[] args) {

		Dribble dribble = new Dribble();
		new Author(dribble);
		new Follower(dribble);
	}

}
