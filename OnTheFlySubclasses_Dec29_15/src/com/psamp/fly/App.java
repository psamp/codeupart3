package com.psamp.fly;

class App {
	
	public static void main(String[] args) {
		
		new Onlooker().watch();
		
		Skate sk = new Skate(){

			@Override
			public void doCoolTrick() {
				System.out.println("*does a flip*");
				
			}
			
		};
		
		sk.doCoolTrick();
	}

}
