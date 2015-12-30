package com.psamp.fly;

class Onlooker {

	public void watch() {
		Skate sk = new Skate(){

			@Override
			public void doCoolTrick() {
				System.out.println("*awes onlookers*");
				
			}
			
		};
		
		sk.doCoolTrick();

	}

}
