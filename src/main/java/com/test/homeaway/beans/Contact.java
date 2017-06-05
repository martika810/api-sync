package com.test.homeaway.beans;

import com.test.homeaway.beans.pojo.ContactPOJO;

public final class Contact {
    
    private final String phone;
    private final String formattedPhone;
    
    private Contact(String phone, String formattedPhone) {
	this.phone = phone;
	this.formattedPhone = formattedPhone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public Contact setPhone(String phone){
	return new Contact(phone,this.formattedPhone);
    }
    
    
    public String getFormattedPhone() {
        return formattedPhone;
    }
    
    public Contact setFormattedPhone(String formattedPhone){
	return new Contact(this.phone,formattedPhone);
    }
    
    public static Contact createInstance(String phone, String formattedPhone){
	return new Contact(phone,formattedPhone);
    }
    
    public ContactPOJO toPOJO(){
	ContactPOJO contact = new ContactPOJO();
	contact.setPhone(this.phone);
	contact.setFormattedPhone(this.formattedPhone);
	return contact;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((formattedPhone == null) ? 0 : formattedPhone.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
	Contact other = (Contact) obj;
	if (formattedPhone == null) {
	    if (other.formattedPhone != null)
		return false;
	} else if (!formattedPhone.equals(other.formattedPhone))
	    return false;
	if (phone == null) {
	    if (other.phone != null)
		return false;
	} else if (!phone.equals(other.phone))
	    return false;
	return true;
    }
    
    

}
