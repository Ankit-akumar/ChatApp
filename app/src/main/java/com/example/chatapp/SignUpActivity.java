package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chatapp.Models.User;
import com.example.chatapp.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // Show progress dialog while creating account
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Please wait while we create your account");

        binding.btnSignUp.setOnClickListener(view -> {
            progressDialog.show();
            auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).
                    addOnCompleteListener(task -> {
                        // close dialog
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            // create a user object
                            User user = new User(binding.etUsername.getText().toString(), binding.etEmail.getText().toString(),
                                    binding.etPassword.getText().toString());

                            // get id of the current logged in user
                            String id = task.getResult().getUser().getUid();

                            // make a child node "Users" in the database and set its value(current user)
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(SignUpActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        // start Sign in activity
        binding.tvClickLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        });
    }
}



