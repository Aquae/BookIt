package com.example.bookit;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.annotations.Nullable;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.FieldValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.GeoPoint;

import java.util.concurrent.TimeoutException;
import java.io.FileInputStream;
import java.io.IOException;
public class FirestoreDBinit {
    public static void main(String[] args) {
        FileInputStream serviceAccount = null;
        Firestore firestore = null;

        try {
            // Load the Firebase service account credentials
            serviceAccount = new FileInputStream("google-services.json");

            // Initialize Firebase using the service account credentials
            FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            firestore = firestoreOptions.getService();

            // Define the document reference
            String documentId = "com.example.bookit.MainActivity.BusinessAccount"; // Replace with the actual document ID
            DocumentReference docRef = firestore.collection("businesses").document(documentId);

            // Read the fields from Firestore
            ApiFuture<DocumentSnapshot> future = docRef.get();

            // Handle exceptions
            DocumentSnapshot document = future.get(5, TimeUnit.SECONDS);
            if (document.exists()) {
                // Get the field values
                String address = document.getString("Address");
                String description = document.getString("Description");
                GeoPoint location = document.getGeoPoint("Location");
                String name = document.getString("Name");

                // Perform operations with the field values
                System.out.println("Address: " + address);
                System.out.println("Description: " + description);
                System.out.println("Location: " + location.getLatitude() + "° N, " + location.getLongitude() + "° E");
                System.out.println("Name: " + name);

                // Update a field
                docRef.update("Description", "Updated description").get(5, TimeUnit.SECONDS);
                System.out.println("Description updated successfully");

                // Delete a field
                docRef.update("Address", FieldValue.delete()).get(5, TimeUnit.SECONDS);
                System.out.println("Address field deleted successfully");
            } else {
                System.out.println("Document does not exist");
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            // Close the FileInputStream and Firestore instances
            if (serviceAccount != null) {
                try {
                    serviceAccount.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}