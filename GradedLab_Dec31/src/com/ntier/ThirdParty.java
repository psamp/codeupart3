package com.ntier;


public class ThirdParty extends Policy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5158268364412889895L;
	private VehicleUse vehicleUse;

	public ThirdParty() {

	}

	public ThirdParty(long id, String zipCode, double base, double liabilityLimit, VehicleUse vehicleUse) {
		super(id, zipCode, base, liabilityLimit);
		this.setVehicleUse(vehicleUse);
	}

	public VehicleUse getVehicleUse() {
		return vehicleUse;
	}

	public void setVehicleUse(VehicleUse vehicleUse) {
		this.vehicleUse = vehicleUse;
	}

}
