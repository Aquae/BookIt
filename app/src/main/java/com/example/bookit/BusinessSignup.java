package com.example.bookit;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;

import android.content.Intent;
public class BusinessSignup extends AppCompatActivity {
    private EditText editName;
    private EditText editDescription;
    private EditText editAddress;
    private EditText editPhoneNumber;
    private EditText editWebsite;
    private Button signupButton;
    private Spinner typeOfBusiness;
    private CollectionReference businessRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.businesssignup_activity);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        // Initialize Firestore collection reference
        businessRef = FirebaseFirestore.getInstance().collection("Business");

        // Initialize views
        editName = findViewById(R.id.edit_name_b);
        editDescription = findViewById(R.id.edit_b_description);
        editAddress = findViewById(R.id.edit_b_address);
        editPhoneNumber = findViewById(R.id.edit_b_number);
        editWebsite = findViewById(R.id.edit_b_website);
        signupButton = findViewById(R.id.signup_button);
        typeOfBusiness = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                // Handle the selected option
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
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
                String type = spinner.getSelectedItem().toString();

                // Create a new business object or model
                Business business = new Business(name, description, address, phoneNumber, website, type);

                // Save the business object to Firestore
                businessRef.add(business)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                // Business object saved successfully
                                String businessId = documentReference.getId();
                                // Optionally, you can show a success message or navigate to another activity
                                Intent intent = new Intent(BusinessSignup.this, ServiceSignup.class);
                                intent.putExtra("businessId", businessId);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                // Error occurred while saving the business object
                                Toast.makeText(BusinessSignup.this, "Failed to save business.", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

    }
}
