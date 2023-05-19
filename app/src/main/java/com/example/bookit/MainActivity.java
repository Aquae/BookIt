package com.example.bookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button userButton;
    private Button businessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setApiKey("AIzaSyDh6PdRjHMt7II6Gy25TWU0Q9g6a4Zrf8I")
                    .setApplicationId("1:620472690744:android:daee378a3dc5b3c0b75ecd")
                    .build();
            FirebaseApp.initializeApp(this, options);
        }
        ;
        userButton = findViewById(R.id.userButton);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Userloginsignup.class);
                startActivity(intent);
            }
        });

        businessButton = findViewById(R.id.businessButton);

        businessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BusinessSignup.class);
                startActivity(intent);
            }
        });
    }

    public static class Account {
        private String name;
        private String email;
        private String password;
        private String location;

        public Account(String name, String email, String password, String location) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    public static class BusinessAccount extends Account {
        private String photo;
        private String description;
        private String websiteLink;
        private List<Service> listOfServices;

        public BusinessAccount(String name, String email, String password, String location, String photo, String description, String websiteLink) {
            super(name, email, password, location);
            this.photo = photo;
            this.description = description;
            this.websiteLink = websiteLink;
            this.listOfServices = new ArrayList<>();
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getWebsiteLink() {
            return websiteLink;
        }

        public void setWebsiteLink(String websiteLink) {
            this.websiteLink = websiteLink;
        }

        public List<Service> getListOfServices() {
            return listOfServices;
        }

        public void setListOfServices(List<Service> listOfServices) {
            this.listOfServices = listOfServices;
        }

        public void addService(Service service) {
            listOfServices.add(service);
        }
    }

    public static class Service {
            private String name;
            private double price;
            private String description;

            public Service(String name, double price, String description) {
                this.name = name;
                this.price = price;
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
}

// test