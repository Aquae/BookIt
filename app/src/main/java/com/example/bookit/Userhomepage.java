package com.example.bookit;

import java.util.ArrayList;
import java.util.List;

public class Userhomepage {
    public static class UserAccount extends MainActivity.Account {
        private List<MainActivity.Service> bookings;

        public UserAccount(String name, String email, String password, String location) {
            super(name, email, password, location);
            this.bookings = new ArrayList<>();
        }

        public List<MainActivity.Service> getBookings() {
            return bookings;
        }

        public void setBookings(List<MainActivity.Service> bookings) {
            this.bookings = bookings;
        }


        public void addBooking(MainActivity.Service service) {
            bookings.add(service);
        }
    }
}
