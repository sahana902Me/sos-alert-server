package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FirebaseInit {

    public static void init() throws Exception {

        if (FirebaseApp.getApps().isEmpty()) {

            String firebaseConfig = System.getenv("FIREBASE_KEY");

            if (firebaseConfig == null) {
                throw new RuntimeException("FIREBASE_KEY not set in environment");
            }

            InputStream serviceAccount =
                    new ByteArrayInputStream(firebaseConfig.getBytes());

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        }
    }
}