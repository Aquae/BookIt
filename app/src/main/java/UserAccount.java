public class UserAccount {
    public class UserAccount extends Account {
        private List<Service> bookings;

        public UserAccount(String name, String email, String password, String location) {
            super(name, email, password, location);
            this.bookings = new ArrayList<>();
        }

        public List<Service> getBookings() {
            return bookings;
        }

        public void setBookings(List<Service> bookings) {
            this.bookings = bookings;
        }


        public void addBooking(Service service) {
            bookings.add(service);
        }
    }
}
