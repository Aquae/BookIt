package com.example.bookit;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DisplayBusiness extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<Business> businesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaybusiness);

        recyclerView = findViewById(R.id.recycler_view);
        businesses = new ArrayList<>();

        // Set up the RecyclerView with a layout manager and the adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(businesses);
        recyclerView.setAdapter(cardAdapter);

        // Fetch data from Firestore for all businesses by default
        fetchBusinesses();
    }

    // Fetch businesses based on the selected type
    public void fetchBusinessesWithType(String businessType) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Businesses")
                .whereEqualTo("type", businessType)  // Filter businesses by type
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        businesses.clear();  // Clear the existing list
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            // Retrieve business data from Firestore document
                            String name = documentSnapshot.getString("name");
                            String description = documentSnapshot.getString("description");

                            // Create a Business object
                            Business business = new Business(name, null, null, null, description, null);
                            businesses.add(business);
                        }
                        // Notify the adapter about the data changes
                        cardAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(DisplayBusiness.this, "Failed to fetch businesses", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Fetch all businesses
    private void fetchBusinesses() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Businesses")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        businesses.clear();  // Clear the existing list
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            // Retrieve business data from Firestore document
                            String name = documentSnapshot.getString("name");
                            String description = documentSnapshot.getString("description");

                            // Create a Business object
                            Business business = new Business(name, null, null, null, description, null);
                            businesses.add(business);
                        }
                        // Notify the adapter about the data changes
                        cardAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(DisplayBusiness.this, "Failed to fetch businesses", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
