package com.accenture.insurance.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="POLICIES")
public class Policy {

	@Id
	@Column(updatable=false, name="pol_id")
	@SequenceGenerator(name="POL_SEQ", sequenceName="POL_SEQ", allocationSize=1)
	@GeneratedValue(generator="POL_SEQ", strategy=GenerationType.SEQUENCE)
	private int number;
	
	@Column(name="pol_type")
	private int type;
	
	@Column(name="state")
	private String state;

	@Column(name="premium")
	private boolean premium;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="exp_date")
	private Date expDate;
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer custId;

	public Policy() {
		super();
	}

	public Policy(int pol_Number, int pol_Type, String state, boolean premium, Date pol_Start_Date,
			Date pol_Exp_Date, Customer cust_Id) {
		super();
		number = pol_Number;
		type = pol_Type;
		this.state = state;
		this.premium = premium;
		startDate = pol_Start_Date;
		expDate = pol_Exp_Date;
		custId = cust_Id;
	}

	public int getPol_Number() {
		return number;
	}

	public void setPol_Number(int pol_Number) {
		number = pol_Number;
	}

	public int getPol_Type() {
		return type;
	}

	public void setPol_Type(int pol_Type) {
		type = pol_Type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Date getPol_Start_Date() {
		return startDate;
	}

	public void setPol_Start_Date(Date pol_Start_Date) {
		startDate = pol_Start_Date;
	}

	public Date getPol_Exp_Date() {
		return expDate;
	}

	public void setPol_Exp_Date(Date pol_Exp_Date) {
		expDate = pol_Exp_Date;
	}

	public Customer getCust_Id() {
		return custId;
	}

	public void setCust_Id(Customer cust_Id) {
		custId = cust_Id;
	}

	@Override
	public String toString() {
		return "Policy [Pol_Number=" + number + ", Pol_Type=" + type + ", State=" + state + ", Premium="
				+ premium + ", Pol_Start_Date=" + startDate + ", Pol_Exp_Date=" + expDate + ", Cust_Id="
				+ custId + "]";
	}
	
	
	
}
