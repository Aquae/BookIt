package com.example.bookit;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class BusinessProfile extends AppCompatActivity {

    private TextView serviceDescription;
    private Button confirmBookingButton;
    private Button selectedServiceButton;
    private Button selectedBookingTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);

        serviceDescription = findViewById(R.id.service_description_1);
        confirmBookingButton = findViewById(R.id.confirm_booking_button);

        Button serviceButton1 = findViewById(R.id.service_button_1);
        serviceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serviceDescription.getVisibility() == View.VISIBLE) {
                    serviceDescription.setVisibility(View.GONE);
                    selectedServiceButton = null;
                } else {
                    serviceDescription.setVisibility(View.VISIBLE);
                    selectedServiceButton = serviceButton1;
                }
            }
        });

        Button bookingTime1 = findViewById(R.id.booking_time_1);
        bookingTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlightBookingTimeButton(bookingTime1);

                // Perform booking operations
                // Add your booking logic here
            }
        });

        confirmBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedServiceButton == null || selectedBookingTimeButton == null) {
                    // Display a message to select a service and booking time first
                    // You can use a Toast or any other UI element to show the message
                    return;
                }

                // Perform confirm booking operations
                // Add your confirm booking logic here
            }
        });
    }

    private void highlightBookingTimeButton(Button button) {
        if (selectedBookingTimeButton != null) {
            selectedBookingTimeButton.setBackgroundResource(android.R.drawable.btn_default);
        }

    }
}