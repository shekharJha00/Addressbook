package com.bridgelabz.adressbook;


public class ContactsDetails {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String city;
    private String state;
    private String zipcode;

    public String getFirst_name() {
        return first_name;
    }
    public void setFirstname(String first_name) {
        this.first_name = first_name;
    }

    public void setLastname(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "First Name : '" + first_name + "', Last Name : '" + last_name + "', Phone Number : '" + phone_number +
                "', email ID : '" + email + "', City : '" + city + "', State : '" + state + "', Zipcode : '" + zipcode + "'\n";
    }
}