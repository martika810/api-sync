package com.test.homeaway.beans;

import com.test.homeaway.beans.pojo.LocationPOJO;

public final class Location {
    private final float lat;
    private final float lng;
    
    private Location(float lat, float lng) {
	this.lat = lat;
	this.lng = lng;
    }

    public float getLat() {
        return lat;
    }
    
    public Location setLat(float lat){
	return new Location(lat, this.lng);
    }

    public float getLng() {
        return lng;
    }
    
    public Location setLng(float lng){
	return new Location(this.lat,lng);
    }
    
    public static Location createInstance(float lat, float lng){
	return new Location(lat,lng);
    }
    
    public LocationPOJO toPOJO(){
	LocationPOJO location = new LocationPOJO();
	location.setLat(this.lat);
	location.setLng(this.lng);
	return location;
    }
    
    public static Location valueOf(LocationPOJO pojo){
	return createInstance(pojo.getLat(), pojo.getLng());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(lat);
	result = prime * result + Float.floatToIntBits(lng);
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
	Location other = (Location) obj;
	if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
	    return false;
	if (Float.floatToIntBits(lng) != Float.floatToIntBits(other.lng))
	    return false;
	return true;
    }
    
    
    

}
