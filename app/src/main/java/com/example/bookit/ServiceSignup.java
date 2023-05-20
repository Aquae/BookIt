package com.example.bookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.firebase.firestore.CollectionReference;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ServiceSignup extends AppCompatActivity {

    private LinearLayout availableTimeSlotsLayout;
    private LinearLayout busyTimeSlotsLayout;
    private Button addAvailableTimeSlotButton;
    private Button addBusyTimeSlotButton;
    private Button submitButton;
    private List<String> availableTimeSlots;
    private List<String> busyTimeSlots;

    private FirebaseFirestore db;
    private CollectionReference serviceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_selection);

        availableTimeSlotsLayout = findViewById(R.id.available_time_slots_layout);
        busyTimeSlotsLayout = findViewById(R.id.busy_time_slots_layout);
        addAvailableTimeSlotButton = findViewById(R.id.add_available_time_slot_button);
        addBusyTimeSlotButton = findViewById(R.id.add_busy_time_slot_button);
        submitButton = findViewById(R.id.submit_button);

        availableTimeSlots = new ArrayList<>();
        busyTimeSlots = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        serviceRef = db.collection("Service");

        addAvailableTimeSlotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (availableTimeSlots.size() < 5) {
                    addTimeSlot(availableTimeSlotsLayout, availableTimeSlots);
                }
            }
        });

        addBusyTimeSlotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (busyTimeSlots.size() < 5) {
                    addTimeSlot(busyTimeSlotsLayout, busyTimeSlots);
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = ((EditText) findViewById(R.id.edit_description)).getText().toString();
                String duration = ((EditText) findViewById(R.id.edit_duration)).getText().toString();
                String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
                String price = ((EditText) findViewById(R.id.edit_price)).getText().toString();
                String timeInCal = ((EditText) findViewById(R.id.edit_time_in_cal)).getText().toString();

                Service service = new Service(description, duration, name, price, timeInCal);

                serviceRef.add(service)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                String serviceId = documentReference.getId();
                                Intent intent = new Intent(ServiceSignup.this, BusinessProfile.class);
                                intent.putExtra("ServiceId", serviceId);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                Toast.makeText(ServiceSignup.this, "Failed to save service.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }

        });
    }

    private void addTimeSlot(LinearLayout layout, List<String> timeSlots) {
        TimePicker timePicker = new TimePicker(this);
        timePicker.setIs24HourView(true);
        layout.addView(timePicker);
        timeSlots.add(getTimeFromTimePicker(timePicker));
    }

    private String getTimeFromTimePicker(TimePicker timePicker) {
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        return String.format("%02d:%02d", hour, minute);
    }
}
