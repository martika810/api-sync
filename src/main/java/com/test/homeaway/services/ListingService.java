package com.test.homeaway.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.homeaway.beans.Listing;

@Component("listingService")
public class ListingService implements IService<String, Listing> {

    private Map<String, Listing> listingMap;
    private Map<String, Listing> unmodifiableMap;

    public ListingService() {
	listingMap = new HashMap<>();
	unmodifiableMap = Collections.unmodifiableMap(listingMap);
    }

    public Listing add(Listing newListing) {

	listingMap.put(newListing.getId(), newListing);
	return unmodifiableMap.get(newListing.getId());
    }

    public Listing update(Listing updatedListing) {
	boolean isExistingListing =  unmodifiableMap.get(updatedListing.getId())!=null;
	if(isExistingListing){
	    listingMap.put(updatedListing.getId(), updatedListing);
	    return unmodifiableMap.get(updatedListing.getId());
	    
	}else{
	    return null;
	}
	
    }

    public Listing read(String listingId) {
	return unmodifiableMap.get(listingId);
    }

    public Listing delete(String listingId) {
	Listing listingToDelete = unmodifiableMap.get(listingId);
	if (listingToDelete != null) {
	    listingMap.remove(listingId);
	}
	return listingToDelete;

    }

}
