package com.psamp.zodiac;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Person implements Comparable<Person> {
	private String zodiacSign;
	private String name;

	Person(String name, String zodiacSign) {
		this.name = name;
		this.zodiacSign = zodiacSign;
	}

	String getZodiacSign() {
		return zodiacSign;
	}

	String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getName() + " | " + this.getZodiacSign();
	}

	@Override
	public int compareTo(Person o) {
		return new ZodiacComparator().compare(this, o);
	}

	class ZodiacComparator implements Comparator<Person> {

		private Map<String, Integer> buildCalendar() {
			Map<String, Integer> rtn = new HashMap<String, Integer>();

			rtn.put("Aquarius", 1);
			rtn.put("Pisces", 2);
			rtn.put("Aries", 3);
			rtn.put("Taurus", 4);
			rtn.put("Gemini", 5);
			rtn.put("Cancer", 6);
			rtn.put("Leo", 7);
			rtn.put("Virgo", 8);
			rtn.put("Libra", 9);
			rtn.put("Scorpio", 10);
			rtn.put("Sagittarius", 11);
			rtn.put("Capricorn", 12);

			return rtn;

		}

		@Override
		public int compare(Person o1, Person o2) {
			Map<String, Integer> calendar = this.buildCalendar();

			int rtn = -99;

			if (calendar.get(o1.getZodiacSign()) > calendar.get(o2.getZodiacSign())) {
				rtn = 1;
			} else if (calendar.get(o1.getZodiacSign()) < calendar.get(o2.getZodiacSign())) {
				rtn = -1;
			} else {
				rtn = 0;
			}

			if (rtn == 0) {
				rtn = o1.getName().compareTo(o2.getName());
			}

			return rtn;

		}

	}

}
