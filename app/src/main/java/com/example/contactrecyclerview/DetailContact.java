package com.example.contactrecyclerview;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.contactrecyclerview.databinding.ActivityDetailContactBinding;

public class DetailContact extends AppCompatActivity {
    private ActivityDetailContactBinding binding;
    private Intent getIntent;
    private TextView email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntent = getIntent();
        this.name = binding.name;
        this.email = binding.email;
        String name = getIntent.getStringExtra("name");
        String email = getIntent.getStringExtra("email");
        this.name.setText(name);
        this.email.setText(email);
    }
}