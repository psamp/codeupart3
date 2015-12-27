package com.psamp.transcipts;

class Transcript {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private int grade;
	private boolean passed;
	
	public Transcript(long id, String firstName, String lastName, String email, int grade, boolean passed) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.grade = grade;
		this.passed = passed;
	}
	
	@Override
	public String toString() {
		return "Transcript [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", grade=" + grade + ", passed=" + passed + "]";
	}

	String getFirstName() {
		return firstName;
	}

	String getLastName() {
		return lastName;
	}

	String getEmail() {
		return email;
	}

	int getGrade() {
		return grade;
	}

	boolean passedTest() {
		return passed;
	}

	long getId() {
		return id;
	}

}
