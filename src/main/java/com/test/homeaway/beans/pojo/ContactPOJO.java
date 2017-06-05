package com.test.homeaway.beans.pojo;

import com.test.homeaway.beans.Contact;

public class ContactPOJO {
    private String phone;
    private String formattedPhone;
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFormattedPhone() {
        return formattedPhone;
    }
    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }
    
    public Contact immutable(){
	return Contact.createInstance(this.getPhone(), this.getFormattedPhone());
    }
    
}
