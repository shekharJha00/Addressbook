package com.bridgelabz.adressbook;

<<<<<<< HEAD

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
=======
public class ContactsDetails {

    private String firstname, lastname, address, city, state, email;
    private int zip;
    private long phonenumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
>>>>>>> 93a3db978bd4c98576fa63773ad0a72cc00c9a9a
    }

    public String getCity() {
        return city;
    }
<<<<<<< HEAD
=======

>>>>>>> 93a3db978bd4c98576fa63773ad0a72cc00c9a9a
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
<<<<<<< HEAD
=======

>>>>>>> 93a3db978bd4c98576fa63773ad0a72cc00c9a9a
    public void setState(String state) {
        this.state = state;
    }

<<<<<<< HEAD
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
>>>>>>> 93a3db978bd4c98576fa63773ad0a72cc00c9a9a
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "First Name : '" + first_name + "', Last Name : '" + last_name + "', Phone Number : '" + phone_number +
                "', email ID : '" + email + "', City : '" + city + "', State : '" + state + "', Zipcode : '" + zipcode + "'\n";
    }
}
=======
        return "ContactsDetails [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", city="
                + city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phonenumber=" + phonenumber
                + "]";
    }

}
>>>>>>> 93a3db978bd4c98576fa63773ad0a72cc00c9a9a
