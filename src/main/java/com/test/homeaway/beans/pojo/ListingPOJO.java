package com.test.homeaway.beans.pojo;

import com.test.homeaway.beans.Listing;

public class ListingPOJO {
    
    private String id;
    private ContactPOJO contact;
    private AddressPOJO address;
    private LocationPOJO location;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ContactPOJO getContact() {
        return contact;
    }
    public void setContact(ContactPOJO contact) {
        this.contact = contact;
    }
    public AddressPOJO getAddress() {
        return address;
    }
    public void setAddress(AddressPOJO address) {
        this.address = address;
    }
    public LocationPOJO getLocation() {
        return location;
    }
    public void setLocation(LocationPOJO location) {
        this.location = location;
    }
   
    public Listing immutable(){
	return Listing.createInstance(this.getId(), this.getContact().immutable(), this.getAddress().immutable(), this.getLocation().immutable());
    }
    
}
