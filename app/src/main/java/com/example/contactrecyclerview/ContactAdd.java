package com.example.contactrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.contactrecyclerview.databinding.ActivityContactAddBinding;

import java.util.ArrayList;

public class ContactAdd extends AppCompatActivity {
    private Intent resultIntent;
    private ActivityContactAddBinding binding;
    private EditText name, email;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        resultIntent = new Intent();
        name = binding.name;
        email = binding.email;
        submit = binding.submit;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = name.getText().toString();
                String emailInput = email.getText().toString();
                if(nameInput.matches("") || emailInput.matches("")){
                    Toast.makeText(ContactAdd.this, "Insert Name and Email", Toast.LENGTH_SHORT).show();
                }
                else{
                    resultIntent.putExtra("name", nameInput);
                    resultIntent.putExtra("email", emailInput);
                    setResult(-1, resultIntent);
                    finish();
                }
            }
        });
    }
}