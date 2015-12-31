package com.ntier;


public class Comphrehensive extends Policy implements Comprehensible {

	/**
	 * 
	 */
	private static final long serialVersionUID = -438756848236812398L;
	private int comprehensive;
	private int collision;

	public Comphrehensive() {

	}

	public Comphrehensive(long id, String zipCode, double base, double liabilityLimit, int comprehensive,
			int collision) {
		super(id, zipCode, base, liabilityLimit);
		this.setComprehensive(comprehensive);
		this.setCollision(collision);
	}

	@Override
	public int getComprehensive() {
		return comprehensive;
	}

	@Override
	public int getCollision() {
		return collision;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setComprehensive(int comprehensive) {
		this.comprehensive = comprehensive;
	}

	public void setCollision(int collision) {
		this.collision = collision;
	}

}
