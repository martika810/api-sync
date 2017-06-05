package com.test.homeaway.controllers;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.homeaway.beans.Address;
import com.test.homeaway.beans.Contact;
import com.test.homeaway.beans.Listing;
import com.test.homeaway.beans.Location;
import com.test.homeaway.beans.pojo.ListingPOJO;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@ComponentScan("com.test.homeaway.services")
@AutoConfigureMockMvc
public class TestListingRestController {

    @Autowired
    private MockMvc mvc;
    
    private static ObjectMapper mapper;
    
    @BeforeClass
    public static void setup(){
	mapper = new ObjectMapper();
    }
    

    @Test
    public void createListing() throws Exception {

	Contact contact = Contact.createInstance("15126841100", "+1 512-684-1100");
	Address address = new Address.Builder().address("1011 W 5th St").postalCode("1011").countryCode("US").city("Austin").state("TX")
		.country("United States").build();
	Location location = Location.createInstance(40.225548f, -3.70756f);
	Listing listing = Listing.createInstance(contact, address, location);
	String listingInJSON = mapper.writeValueAsString(listing.toPOJO());

	mvc.perform(MockMvcRequestBuilders.post("/listing").contentType(MediaType.APPLICATION_JSON).content(listingInJSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.contact.phone").value("15126841100"))
		.andExpect(jsonPath("$.contact.formattedPhone").value("+1 512-684-1100"))
		.andExpect(jsonPath("$.address.address").value("1011 W 5th St")).andExpect(jsonPath("$.address.postalCode").value("1011"))
		.andExpect(jsonPath("$.address.countryCode").value("US")).andExpect(jsonPath("$.address.city").value("Austin"))
		.andExpect(jsonPath("$.address.state").value("TX")).andExpect(jsonPath("$.address.country").value("United States"))
		.andExpect(jsonPath("$.location.lat").value(40.225548)).andExpect(jsonPath("$.location.lng").value(-3.70756));
    }

    @Test
    public void read() throws Exception {
	
	ListingPOJO createdListing = postNewListing();

	// Get request to retrieve just created listing
	mvc.perform(MockMvcRequestBuilders.get("/listing/" + createdListing.getId())).andExpect(status().isOk())
		.andExpect(jsonPath("$.contact.phone").value("15126841100"))
		.andExpect(jsonPath("$.contact.formattedPhone").value("+1 512-684-1100"))
		.andExpect(jsonPath("$.address.address").value("1011 W 5th St")).andExpect(jsonPath("$.address.postalCode").value("1011"))
		.andExpect(jsonPath("$.address.countryCode").value("US")).andExpect(jsonPath("$.address.city").value("Austin"))
		.andExpect(jsonPath("$.address.state").value("TX")).andExpect(jsonPath("$.address.country").value("United States"))
		.andExpect(jsonPath("$.location.lat").value(40.225548)).andExpect(jsonPath("$.location.lng").value(-3.70756));
    }

    @Test
    public void update() throws Exception {
	
	ListingPOJO createdListing = postNewListing();
	
	//update listing
	createdListing.getContact().setPhone("88888888");
	createdListing.getLocation().setLat(2.2222f);
	createdListing.getLocation().setLng(2.2222f);
	String listingInJSON = mapper.writeValueAsString(createdListing);
	
	//put request
	mvc.perform(MockMvcRequestBuilders.put("/listing").contentType(MediaType.APPLICATION_JSON).content(listingInJSON))
	.andExpect(status().isOk())
	.andExpect(jsonPath("$.contact.phone").value("88888888"))
	.andExpect(jsonPath("$.location.lat").value(2.2222))
	.andExpect(jsonPath("$.location.lng").value(2.2222));
    }

    @Test
    public void delete() throws Exception {
	
	ListingPOJO createdListing = postNewListing();
	
	mvc.perform(MockMvcRequestBuilders.delete("/listing/"+createdListing.getId())).andExpect(status().isOk());
	
	mvc.perform(MockMvcRequestBuilders.get("/listing/" + createdListing.getId())).andExpect(status().isNotFound());
	
    }

    private ListingPOJO postNewListing() throws Exception{
	
	// create a new listing object
	Contact contact = Contact.createInstance("15126841100", "+1 512-684-1100");
	Address address = new Address.Builder().address("1011 W 5th St").postalCode("1011").countryCode("US").city("Austin").state("TX")
		.country("United States").build();
	Location location = Location.createInstance(40.225548f, -3.70756f);
	Listing listing = Listing.createInstance(contact, address, location);
	String listingInJSON = new ObjectMapper().writeValueAsString(listing.toPOJO());

	// post request
	MvcResult result = mvc
		.perform(MockMvcRequestBuilders.post("/listing").contentType(MediaType.APPLICATION_JSON).content(listingInJSON))
		.andExpect(status().isOk()).andReturn();
	
	//Convert JSON String to Object 
	ListingPOJO createdListing = mapper.readValue(result.getResponse().getContentAsString(), ListingPOJO.class);
	return createdListing;
    }

}
