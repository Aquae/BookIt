package com.example.bookit;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// implements View.OnClickListener  ***Previously added
public class UserHomepage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage_activity);

        ////******CHANGES FROM HERE***

        Button chiropractorButton = findViewById(R.id.Chiropractor);
        chiropractorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectChiropractor();
            }
        });

        Button physiotherapistButton = findViewById(R.id.Physiotherapist);
        physiotherapistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPhysiotherapist();
            }
        });

        Button dentistButton = findViewById(R.id.Dentist);
        dentistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDentist();
            }
        });
    }

    public void selectHairdresser() {
        Intent intent = new Intent(this, DisplayBusiness.class);
        intent.putExtra("type", "Hairdresser");
        startActivity(intent);
    }

    public void selectChiropractor() {
        Intent intent = new Intent(this, DisplayBusiness.class);
        intent.putExtra("type", "Chiropractor");
        startActivity(intent);
    }

    public void selectPhysiotherapist() {
        Intent intent = new Intent(this, DisplayBusiness.class);
        intent.putExtra("type", "Physiotherapist");
        startActivity(intent);
    }

    public void selectDentist() {
        Intent intent = new Intent(this, DisplayBusiness.class);
        intent.putExtra("type", "Dentist");
        startActivity(intent);
    }
}


//
//        ImageView hairdresserImage = findViewById(R.id.Hairdresser);
//        ImageView chiropractorImage = findViewById(R.id.Chiropractor);
//        ImageView restaurantImage = findViewById(R.id.Dentist);
//        ImageView physiotherapistImage = findViewById(R.id.Physiotherapist);
//
//        hairdresserImage.setOnClickListener(this);
//        chiropractorImage.setOnClickListener(this);
//        restaurantImage.setOnClickListener(this);
//        physiotherapistImage.setOnClickListener(this);
//    }
//
//    public void selectHairdresser() {
//        // Code to handle hairdresser selection
//        // You can instantiate DisplayBusiness and pass the selected type as an argument
//        DisplayBusiness displayBusiness = new DisplayBusiness();
//        displayBusiness.fetchBusinessesWithType("Hairdresser");
//    }
//
//    public void selectMechanic() {
//        // Code to handle mechanic selection
//        // You can instantiate DisplayBusiness and pass the selected type as an argument
//        DisplayBusiness displayBusiness = new DisplayBusiness();
//        displayBusiness.fetchBusinessesWithType("Chiropractor");
//    }
//
//    public void selectRestaurant() {
//        // Code to handle restaurant selection
//        // You can instantiate DisplayBusiness and pass the selected type as an argument
//        DisplayBusiness displayBusiness = new DisplayBusiness();
//        displayBusiness.fetchBusinessesWithType("Physiotherapy");
//    }
//
//    public void selectPhysiotherapist() {
//        // Code to handle physiotherapist selection
//        // You can instantiate DisplayBusiness and pass the selected type as an argument
//        DisplayBusiness displayBusiness = new DisplayBusiness();
//        displayBusiness.fetchBusinessesWithType("Dentist");
//    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.Hairdresser:
//                selectHairdresser();
//                break;
//            case R.id.Chiropractor:
//                selectMechanic();
//                break;
//            case R.id.Dentist:
//                selectRestaurant();
//                break;
//            case R.id.Physiotherapist:
//                selectPhysiotherapist();
//                break;
//        }
//    }

//}
