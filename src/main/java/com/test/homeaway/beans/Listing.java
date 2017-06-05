package com.test.homeaway.beans;

import java.util.UUID;

import com.test.homeaway.beans.pojo.ListingPOJO;

public class Listing {
   
    private final String id;
    private final Contact contact;
    private final Address address;
    private final Location location;
    
    private Listing(String id,Contact contact, Address address, Location location) {
	this.id = id;
	this.contact = contact;
	this.address = address;
	this.location = location;
    }
    
    public static Listing createInstance(Contact contact,Address address,Location location){
	return new Listing(UUID.randomUUID().toString(),contact,address,location);
    }
    
    public static Listing createInstance(String id,Contact contact,Address address,Location location){
	return new Listing(id.toString(),contact,address,location);
    }
    
    public String getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }
    
    

    public Address getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }
    
    public ListingPOJO toPOJO(){
	ListingPOJO listing = new ListingPOJO();
	listing.setId(this.id);
	listing.setContact(this.contact.toPOJO());
	listing.setAddress(this.address.toPOJO());
	listing.setLocation(this.location.toPOJO());
	return listing;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((contact == null) ? 0 : contact.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
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
	Listing other = (Listing) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (contact == null) {
	    if (other.contact != null)
		return false;
	} else if (!contact.equals(other.contact))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (location == null) {
	    if (other.location != null)
		return false;
	} else if (!location.equals(other.location))
	    return false;
	return true;
    }
    
    
    
    
    
    

}
