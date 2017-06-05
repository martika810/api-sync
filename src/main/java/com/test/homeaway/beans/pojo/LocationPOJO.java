package com.test.homeaway.beans.pojo;

import com.test.homeaway.beans.Location;

public class LocationPOJO {
    private float lat;
    private float lng;
    
    public float getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }
    public float getLng() {
        return lng;
    }
    public void setLng(float lng) {
        this.lng = lng;
    }
    
    public Location immutable(){
	return Location.createInstance(this.getLat(), this.getLng());
    }
    
    
}
