package com.test.homeaway.beans;

import com.test.homeaway.beans.pojo.AddressPOJO;

public final class Address {
    public final String address;
    public final String postalCode;
    public final String countryCode;
    public final String city;
    public final String state;
    public final String country;

    private Address(Builder builder) {
	this.address = builder.address;
	this.postalCode=builder.postalCode;
	this.countryCode=builder.countryCode;
	this.city = builder.city;
	this.state = builder.state;
	this.country = builder.country;
    }

    public static class Builder {
	public String address;
	public String postalCode;
	public String countryCode;
	public String city;
	public String state;
	public String country;
	
	public Builder address(String address){
	    this.address = address;
	    return this;
	}
	public Builder postalCode(String postalCode){
	    this.postalCode =postalCode;
	    return this;
	}
	public Builder countryCode(String countryCode){
	    this.countryCode = countryCode;
	    return this;
	}
	public Builder city(String city){
	    this.city = city;
	    return this;
	}
	public Builder state(String state){
	    this.state =state;
	    return this;
	}
	public Builder country(String country){
	    this.country = country;
	    return this;
	}
	
	public Address build(){
	    return new Address(this);
	}
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
    
    public AddressPOJO toPOJO(){
	AddressPOJO address = new AddressPOJO();
	address.setAddress(this.address);
	address.setPostalCode(this.postalCode);
	address.setCountryCode(this.countryCode);
	address.setCity(this.city);
	address.setState(this.state);
	address.setCountry(this.country);
	return address;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
	result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Address other = (Address) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (city == null) {
	    if (other.city != null)
		return false;
	} else if (!city.equals(other.city))
	    return false;
	if (country == null) {
	    if (other.country != null)
		return false;
	} else if (!country.equals(other.country))
	    return false;
	if (countryCode == null) {
	    if (other.countryCode != null)
		return false;
	} else if (!countryCode.equals(other.countryCode))
	    return false;
	if (postalCode == null) {
	    if (other.postalCode != null)
		return false;
	} else if (!postalCode.equals(other.postalCode))
	    return false;
	if (state == null) {
	    if (other.state != null)
		return false;
	} else if (!state.equals(other.state))
	    return false;
	return true;
    }
    
    

}
