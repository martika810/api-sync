package com.test.homeaway.beans.pojo;

import com.test.homeaway.beans.Address;
import com.test.homeaway.beans.Address.Builder;

public class AddressPOJO {
    public String address;
    public String postalCode;
    public String countryCode;
    public String city;
    public String state;
    public String country;
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    public Address immutable(){
	return new Builder()
	.address(this.getAddress())
	.postalCode(this.getPostalCode())
	.countryCode(this.getCountryCode())
	.city(this.getCity())
	.state(this.getState())
	.country(this.getCountry())
	.build();
    }
    
    
}
