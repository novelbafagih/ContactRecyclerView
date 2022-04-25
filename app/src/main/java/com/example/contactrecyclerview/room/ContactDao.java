package com.example.contactrecyclerview.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> getAll();

    @Query("SELECT * FROM contact WHERE uid LIKE :uid")
    Contact findById(String uid);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Contact contacts);

    @Delete
    void delete(Contact contact);
}
