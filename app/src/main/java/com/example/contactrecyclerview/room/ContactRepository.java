package com.example.contactrecyclerview.room;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private LiveData<List<Contact>> AllContact;

    public ContactRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        contactDao = db.contactDao();
        AllContact = contactDao.getAll();
    }

    public LiveData<List<Contact>> getAllContact() {
        return AllContact;
    }

    public void insert(Contact contact){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.insertAll(contact);
        });
    }
    public void delete(Contact contact){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.delete(contact);
        });
    }
}
