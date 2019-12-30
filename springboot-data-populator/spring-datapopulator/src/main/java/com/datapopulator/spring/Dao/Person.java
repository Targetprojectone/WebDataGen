package com.datapopulator.spring.Dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	
	public Person() {
	}
	public Person( Integer personId, String firstName, String lastName, int age, String countryOfresidence  ){
		this.personId = personId;
		this.firstName = firstName;
		this.lastName =lastName;
		this.age =age;
		this.countryOfResidence = countryOfresidence;
		
	}
	public Person( String firstName, String lastName, int age, String countryOfresidence  ){
		this.firstName = firstName;
		this.lastName =lastName;
		this.age =age;
		this.countryOfResidence = countryOfresidence;
		
	}
	@Id
	@GeneratedValue
	private int personId;
	
	private String firstName;
	

	private String lastName;
	

	private int age;

	private String countryOfResidence;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	
	

}
