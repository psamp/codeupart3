package com.psamp.transcipts;

public class Transcript {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String dateTaken;
	private int grade;
	private boolean passed;

	public Transcript(long id, String firstName, String lastName, String email, String dateTaken, int grade) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateTaken = dateTaken;
		this.grade = grade;
		this.passed = grade > 68;
	}

	@Override
	public String toString() {
		return "Transcript [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", grade=" + grade + ", passed=" + passed + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getGrade() {
		return grade;
	}

	public boolean passedTest() {
		return passed;
	}

	long getId() {
		return id;
	}

	public String getDateTaken() {
		return dateTaken;
	}

	public boolean isPassed() {
		return passed;
	}

}
