package com.psamp;

class Car {
	private String make;

	@Override
	public String toString() {
		return make;
	}
	
	class Engine {
		int size;
		
		void describe(){
			System.out.println(size + "  " + make);
		}
	}

}
