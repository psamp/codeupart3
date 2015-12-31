package com.ntier;


class InsurancePolicyFactory {

	public static Policy getInstance(long id, String zipCode, double base, int liabilityLimit, int comprehensive,
			int collision) {
		return new Comphrehensive(id, zipCode, base, liabilityLimit, comprehensive, collision);
	}

	public static Policy getInstance(long id, String zipCode, double base, int liabilityLimit, VehicleUse vehicleUse) {

		return new ThirdParty(id, zipCode, base, liabilityLimit, vehicleUse);
	}

}
