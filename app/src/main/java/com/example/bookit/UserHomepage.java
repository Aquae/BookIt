package com.example.bookit;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage_activity);

        Set<String> businessTypes = new HashSet<String>();
        getBusinessTypes(businessTypes);
    }

    private void getBusinessTypes(Set<String> businessTypes) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Business")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            String businessType = documentSnapshot.getString("Type");
                            if (businessType != null && businessType != "") {
                                businessTypes.add(businessType);
                            }
                        }
                        fillSpinner(businessTypes);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.w("getBusinessTypes", e.toString());
                    }
                });
    }

    private void fillSpinner(Set<String> businessTypes) {
        List<String> businessTypesL = new ArrayList<String>(businessTypes);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, businessTypesL);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Intent intent = new Intent(UserHomepage.this, DisplayBusiness.class);
                intent.putExtra("type", spinner.getSelectedItem().toString());
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.i("Cool", "Story Bro");
            }
        });
    }
}