package com.example.bookit;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Userhomepage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage_activity);

        ImageView hairdresserImage = findViewById(R.id.Hairdresser);
        ImageView chiropractorImage = findViewById(R.id.Chiropractor);
        ImageView restaurantImage = findViewById(R.id.Dentist);
        ImageView physiotherapistImage = findViewById(R.id.Physiotherapist);

        hairdresserImage.setOnClickListener(this);
        chiropractorImage.setOnClickListener(this);
        restaurantImage.setOnClickListener(this);
        physiotherapistImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Hairdresser:
                selectHairdresser();
                break;
            case R.id.Chiropractor:
                selectMechanic();
                break;
            case R.id.Dentist:
                selectRestaurant();
                break;
            case R.id.Physiotherapist:
                selectPhysiotherapist();
                break;
        }
    }

    public void selectHairdresser() {
        // Code to handle hairdresser selection
        // You can instantiate DisplayBusiness and pass the selected type as an argument
        DisplayBusiness displayBusiness = new DisplayBusiness();
        displayBusiness.fetchBusinessesWithType("Hairdresser");
    }

    public void selectMechanic() {
        // Code to handle mechanic selection
        // You can instantiate DisplayBusiness and pass the selected type as an argument
        DisplayBusiness displayBusiness = new DisplayBusiness();
        displayBusiness.fetchBusinessesWithType("Chiropractor");
    }

    public void selectRestaurant() {
        // Code to handle restaurant selection
        // You can instantiate DisplayBusiness and pass the selected type as an argument
        DisplayBusiness displayBusiness = new DisplayBusiness();
        displayBusiness.fetchBusinessesWithType("Physiotherapy");
    }

    public void selectPhysiotherapist() {
        // Code to handle physiotherapist selection
        // You can instantiate DisplayBusiness and pass the selected type as an argument
        DisplayBusiness displayBusiness = new DisplayBusiness();
        displayBusiness.fetchBusinessesWithType("Dentist");
    }
}
