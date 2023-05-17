import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
public class FirestoreDBinit {
    public static void main(String[] args) throws IOException {
        // Load the Firebase service account credentials
        FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

        // Initialize Firebase using the service account credentials
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        // Get the Firestore instance
        Firestore firestore = FirestoreClient.getFirestore();

        // Prompt the user for input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Enter the longitude: ");
        double longitude = scanner.nextDouble();

        // Create a new business object
        Business business = new Business(name, description, latitude, longitude);

        // Add the business object to Firestore
        DocumentReference businessRef = firestore.collection("businesses").document();
        businessRef.set(business);

        // Access the ID of the newly created document
        String businessId = businessRef.getId();
        System.out.println("Business ID: " + businessId);
    }

    private static class Business {
        private String name;
        private String description;
        private double latitude;
        private double longitude;

        public Business() {
        }

        public Business(String name, String description, double latitude, double longitude) {
            this.name = name;
            this.description = description;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        // Getters and setters
        // ...
    }
}