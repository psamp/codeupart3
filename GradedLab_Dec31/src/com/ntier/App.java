package com.ntier;


class App {

	public static void main(String[] args) {

		System.out.println(PolicyHolderFactory
				.getInstance("Obi-Wan", "Kenobi", "75024", BarcodeParser.readFile("policies.txt")));

	}

}
