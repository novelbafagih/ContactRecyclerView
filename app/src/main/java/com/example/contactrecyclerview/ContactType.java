package com.example.contactrecyclerview;


import java.io.Serializable;

public class ContactType implements Serializable {
    public String name;
    public String email;

    public ContactType(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
