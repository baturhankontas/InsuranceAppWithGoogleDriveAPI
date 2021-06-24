package com.accenture.insurance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESSES")
public class Address {

	@Id
	@Column(updatable=false, name="add_id")
	@SequenceGenerator(name="ADD_SEQ", sequenceName="ADD_SEQ", allocationSize=1)
	@GeneratedValue(generator="ADD_SEQ", strategy=GenerationType.SEQUENCE)
	private int addId;
	
	@Column(name="first_line")
	private String line1;
	
	@Column(name="second_line")
	private String line2;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="country")
	private String country;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int add_Id, String line1, String line2, String state, String city, int zip, String country) {
		super();
		addId = add_Id;
		this.line1 = line1;
		this.line2 = line2;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public int getAdd_Id() {
		return addId;
	}

	public void setAdd_Id(int add_Id) {
		addId = add_Id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [Add_Id=" + addId + ", Line1=" + line1 + ", Line2=" + line2 + ", State=" + state + ", City="
				+ city + ", Zip=" + zip + ", Country=" + country + "]";
	}
	
	
	
	
	
}
