package com.example.bookit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import android.widget.Toast;



public class UserLoginSignUp extends AppCompatActivity {
    // Firebase Authentication
    private FirebaseAuth mAuth;

    // Views
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.userloginsignup_activity);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Find views by their IDs
        emailEditText = findViewById(R.id.edittextemail);
        passwordEditText = findViewById(R.id.edittextpassword);
        loginButton = findViewById(R.id.loginbutton);
        signupButton = findViewById(R.id.signupbutton);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                loginWithEmail(email, password);
                Intent intent = new Intent(UserLoginSignUp.this, UserHomepage.class);
                startActivity(intent);
            }
        });

        // Set click listener for signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                signupWithEmail(email, password);
                Intent intent = new Intent(UserLoginSignUp.this, UserHomepage.class);
                startActivity(intent);
            }
        });
    }

    private void loginWithEmail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Login successful
                            FirebaseUser user = mAuth.getCurrentUser();
                            // Handle the logged-in user
                            // You can navigate to another activity or perform further actions
                        } else {
                            // Login failed
                            Toast.makeText(UserLoginSignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signupWithEmail(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Signup successful
                            FirebaseUser user = mAuth.getCurrentUser();
                            // Handle the signed-up user
                            // You can navigate to another activity or perform further actions
                        } else {
                            // Signup failed
                            Toast.makeText(UserLoginSignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}