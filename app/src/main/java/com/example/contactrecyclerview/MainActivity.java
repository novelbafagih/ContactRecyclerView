package com.example.contactrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactrecyclerview.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<ContactType> contactDataset;
    private RecyclerView contactRecycler;
    private ContactDataset contactDatasetClass;
    private Intent addIntent;
    private FloatingActionButton addButton, refreshButton;
    private ContactAdapter contactAdapter;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String name = data.getStringExtra("name");
                        String email = data.getStringExtra("email");
                        contactDatasetClass.addData(name,email);
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        contactRecycler = binding.recyclerView;
        addButton = binding.floatingActionButton;
        refreshButton = binding.refresh;
        addIntent = new Intent(this, ContactAdd.class);

        initDataset();
        setUpRecyclerView();


        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactRecycler.setAdapter(contactAdapter);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someActivityResultLauncher.launch(addIntent);
            }
        });
    }

    private void setUpRecyclerView(){
        contactAdapter = new ContactAdapter(contactDataset);
        contactRecycler.setAdapter(contactAdapter);
        contactRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDataset(){
        contactDatasetClass = new ContactDataset();
        this.contactDataset = contactDatasetClass.getContactTypes();
    }
}