package com.accenture.insurance.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer {

	@Id
	@Column(updatable=false, name="cust_id")
	@SequenceGenerator(name="CUST_SEQ", sequenceName="CUST_SEQ", allocationSize=1)
	@GeneratedValue(generator="CUST_SEQ", strategy=GenerationType.SEQUENCE)
	private int custId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne
	@JoinColumn(name="add_id")
	private Address address;
	
	@Column(name="age")
	private int age;
	
	@Column(name="dob")
	private Date dob;

	public Customer() {
		super();
	}

	public Customer(int cust_Id, String first_Name, String last_Name, Address add_Id, int age, Date dOB) {
		super();
		custId = cust_Id;
		firstName = first_Name;
		lastName = last_Name;
		address = add_Id;
		this.age = age;
		this.dob = dOB;
	}

	public int getCust_Id() {
		return custId;
	}

	public void setCust_Id(int cust_Id) {
		custId = cust_Id;
	}

	public String getFirst_Name() {
		return firstName;
	}

	public void setFirst_Name(String first_Name) {
		firstName = first_Name;
	}

	public String getLast_Name() {
		return lastName;
	}

	public void setLast_Name(String last_Name) {
		lastName = last_Name;
	}

	public Address getAdd_Id() {
		return address;
	}

	public void setAdd_Id(Address add_Id) {
		address = add_Id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDOB() {
		return dob;
	}

	public void setDOB(Date dOB) {
		this.dob = dOB;
	}

	@Override
	public String toString() {
		return "Customer [Cust_Id=" + custId + ", First_Name=" + firstName + ", Last_Name=" + lastName + ", Add_Id="
				+ address + ", Age=" + age + ", DOB=" + dob + "]";
	}
	
	
	
	
	
}
