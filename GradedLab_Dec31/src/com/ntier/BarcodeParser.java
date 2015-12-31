package com.ntier;


import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class BarcodeParser {
	private static List<Policy> policies = new ArrayList<Policy>();
	
	public static List<Policy> readFile(String fileName) {
		
		policies.clear();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			
			while(reader.readLine() != null) {
				String line = reader.readLine();
				policies.add(BarcodeParser.parseBarcode(line));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return policies;
	}

	private static Policy parseBarcode(String barcode) {

		String[] barcodeArr = barcode.split("\\|");
		Policy rtn = null;

		try {

			if ("COMP".equals(barcodeArr[2])) {

				rtn = BarcodeParser.buildCOMP(barcodeArr);
			} else if ("THIRD".equals(barcodeArr[2])) {

				rtn = BarcodeParser.buildTHIRD(barcodeArr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtn;
	}

	private static Policy buildCOMP(String[] barcodeArr) {
		return InsurancePolicyFactory.getInstance(Long.parseLong(barcodeArr[0]), barcodeArr[1],
				Double.parseDouble(barcodeArr[3]), Integer.parseInt(barcodeArr[4]), Integer.parseInt(barcodeArr[5]),
				Integer.parseInt(barcodeArr[6]));
	}

	private static Policy buildTHIRD(String[] barcodeArr) {
		VehicleUse vu = null;

		try (XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(barcodeArr[5].getBytes()))) {
			vu = (VehicleUse) decoder.readObject();
		}

		return InsurancePolicyFactory.getInstance(Long.parseLong(barcodeArr[0]), barcodeArr[1],
				Double.parseDouble(barcodeArr[3]), Integer.parseInt(barcodeArr[4]), vu);
	}

}
