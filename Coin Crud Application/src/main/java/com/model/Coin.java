package com.model;

public class Coin {
	String coinName;
	String coinQuantity;
	String value;
	String countryOfOrigin;
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Coin(String coinName, String coinQuantity, String value, String country) {
		super();
		this.coinName = coinName;
		this.coinQuantity = coinQuantity;
		this.value = value;
		this.countryOfOrigin = country;
	}


	public String getCoinName() {
		return coinName;
	}


	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}


	public String getCoinQuantity() {
		return coinQuantity;
	}


	public void setCoinQuantity(String coinQuantity) {
		this.coinQuantity = coinQuantity;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}


	public void setCountry(String country) {
		this.countryOfOrigin = country;
	}
	
	
}
