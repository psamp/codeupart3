package com.psamp.zodiac;

import java.util.ArrayList;
import java.util.Collections;

class App {
	
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Princess", "Capricorn"));
		people.add(new Person("Ares", "Aries"));
		people.add(new Person("Jane", "Aquarius"));
		people.add(new Person("Rodney", "Capricorn"));
		people.add(new Person("J", "Cancer"));
		people.add(new Person("Victoria", "Gemini"));
		people.add(new Person("Shelby", "Taurus"));
		people.add(new Person("Third", "Sagittarius"));
		people.add(new Person("Halsey", "Libra"));
		people.add(new Person("Bucky Barnes", "Leo"));
		people.add(new Person("Shanterria", "Cancer"));
		people.add(new Person("Zoe", "Sagittarius"));
		people.add(new Person("Sami", "Aries"));
		people.add(new Person("Rey", "Aquarius"));
		
		Collections.sort(people);
		
		for (Person person : people) {
			System.out.println(person.toString());
		}
		
	}

}
