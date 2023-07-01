package com.ajayam.mycontactapp.models;

public class ContactList {
    private String name;
    private Integer number;

    private String countryCode;

    public ContactList(String name, Integer number, String countryCode) {
        this.name = name;
        this.number = number;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
