public class BusinessAccount {
    public class BusinessAccount extends Account {
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
    }}
