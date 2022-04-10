package com.example.contactrecyclerview;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactDataset implements Serializable {
    private ArrayList<ContactType> contactTypes;

    public ContactDataset() {
        contactTypes = new ArrayList<ContactType>();
        contactTypes.add(createContactType("Novel","mail.com"));
    }

    public void addData(String name, String email){
        contactTypes.add(createContactType(name, email));
    }

    public void removeData(int postion){
        contactTypes.remove(postion);
    }

    public ArrayList<ContactType> getContactTypes() {
        return contactTypes;
    }

    private ContactType createContactType(String name, String email){
       return new ContactType(name,email) ;
    }
}
