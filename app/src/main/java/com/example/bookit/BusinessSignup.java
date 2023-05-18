package com.example.bookit;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BusinessSignup extends AppCompatActivity {
    private EditText editName;
    private EditText editDescription;
    private EditText editAddress;
    private EditText editPhoneNumber;
    private EditText editWebsite;
    private Button signupButton;

    private CollectionReference businessRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.businesssignup_activity);

        // Initialize Firestore collection reference
        businessRef = FirebaseFirestore.getInstance().collection("Businesses");

        // Initialize views
        editName = findViewById(R.id.edit_name_b);
        editDescription = findViewById(R.id.edit_b_description);
        editAddress = findViewById(R.id.edit_b_address);
        editPhoneNumber = findViewById(R.id.edit_b_number);
        editWebsite = findViewById(R.id.edit_b_website);
        signupButton = findViewById(R.id.signup_button);

        // Set click listener for the signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input values
                String name = editName.getText().toString();
                String description = editDescription.getText().toString();
                String address = editAddress.getText().toString();
                String phoneNumber = editPhoneNumber.getText().toString();
                String website = editWebsite.getText().toString();

                // Create a new business object or model
                Business business = new Business(name, description, address, phoneNumber, website);

                // Save the business object to Firestore


                // Optionally, you can show a success message or navigate to another activity
            }

        });

    }
}
