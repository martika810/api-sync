package com.test.homeaway.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.homeaway.beans.Listing;
import com.test.homeaway.beans.pojo.ListingPOJO;
import com.test.homeaway.services.ListingService;
import com.test.homeaway.services.IService;

@RestController
@RequestMapping("/listing")
public class ListingRestController {

    @Autowired
    @Qualifier("listingService")
    private IService<String,Listing> service;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ListingPOJO> createListing(@RequestBody ListingPOJO listing) {
	try {
	    listing.setId(UUID.randomUUID().toString());
	    Listing newListing = service.add(listing.immutable());
	    return ResponseEntity.status(HttpStatus.OK).body(newListing.toPOJO());
	} catch (Exception ex) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error", ex.getLocalizedMessage()).body(null);
	}
    }

    @RequestMapping(value="/{listingId}" , method = RequestMethod.GET)
    public ResponseEntity<ListingPOJO> read(@PathVariable String listingId) {
	Listing retrievedListing = service.read(listingId);
	if(retrievedListing == null){
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}else{
	    return ResponseEntity.status(HttpStatus.OK).body(retrievedListing.toPOJO());    
	}
	
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ListingPOJO> update(@RequestBody ListingPOJO listing) {
	Listing updatedListing = service.update(listing.immutable());
	if(updatedListing == null){
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}else{
	    return ResponseEntity.status(HttpStatus.OK).body(updatedListing.toPOJO());  
	}
    }

    @RequestMapping(value="/{listingId}" , method = RequestMethod.DELETE)
    public ResponseEntity<ListingPOJO> delete(@PathVariable String listingId) {
	Listing deletedListing = service.delete(listingId);
	if(deletedListing == null){
	    ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	return ResponseEntity.status(HttpStatus.OK).body(deletedListing.toPOJO());
    }

    public IService<String,Listing> getService() {
	return service;
    }

    public void setService(IService<String,Listing> service) {
	this.service = service;
    }

}
