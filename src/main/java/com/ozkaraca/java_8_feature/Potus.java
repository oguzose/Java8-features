package com.ozkaraca.java_8_feature;

import java.util.List;

public class Potus {

	private String firstName;

	private String lastName;

	private int electionYear;

	private String party;

	private List<Wife> wifes;

	public Potus(String firstName, String lastName, int electionYear,
			String party) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.electionYear = electionYear;
		this.party = party;
	}

	public Potus(String firstName, String lastName, int electionYear,
			String party, List<Wife> wifes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.electionYear = electionYear;
		this.party = party;
		this.wifes = wifes;
	}

	public List<Wife> getWifes() {
		return wifes;
	}

	public void setWifes(List<Wife> wifes) {
		this.wifes = wifes;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getElectionYear() {
		return electionYear;
	}

	public void setElectionYear(int electionYear) {
		this.electionYear = electionYear;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Potus [firstName=" + firstName + ", lastName=" + lastName
				+ ", electionYear=" + electionYear + ", party=" + party + "]";
	}

}
