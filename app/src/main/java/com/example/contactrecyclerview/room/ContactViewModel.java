package com.example.contactrecyclerview.room;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    private ContactRepository contactRepository;
    private final LiveData<List<Contact>> AllContact;
    public ContactViewModel (Application application){
        super(application);
        contactRepository = new ContactRepository(application);
        AllContact = contactRepository.getAllContact();
    }

    public LiveData<List<Contact>> getAllContact() {
        return AllContact;
    }
    public void insert(Contact contact) { contactRepository.insert(contact); }
    public void delete(Contact contact) { contactRepository.delete(contact); }

}
