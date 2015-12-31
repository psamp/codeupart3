package com.ntier;


public class PolicyHolder {

	private String id;

	PolicyHolder() {
	}

	PolicyHolder(String id) {
		setId(id);
	}

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + "]";
	}

}
