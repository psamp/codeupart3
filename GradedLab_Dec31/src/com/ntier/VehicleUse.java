package com.ntier;


import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class VehicleUse {

	private List<String> vehicleUse;

	public List<String> getVehicleUse() {
		return vehicleUse;
	}

	public void setVehicleUse(List<String> vehicleUse) {
		this.vehicleUse = vehicleUse;
	}

	public static void main(String args[]) throws FileNotFoundException {
		VehicleUse u = new VehicleUse();
		List l = new ArrayList();
		l.add("Commercial");
		l.add("Work");
		l.add("Recreational");
		u.setVehicleUse(l);

		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Test.xml")));
		enc.writeObject(u);
		enc.close();

		// LEncoder decode = XMLDecoder(new ByteArrayInputStream('<java
		// version="1.6.0_45" class="java.beans.XMLDecoder"><object
		// class="com.ntier.VehicleUse"><void property="vehicleUse"><object
		// class="java.util.ArrayList"><void
		// method="add"><string>Commercial</string></void><void
		// method="add"><string>Work</string></void><void
		// method="add"><string>Recreational</string></void></object></void></object></java>"));
	}

}
