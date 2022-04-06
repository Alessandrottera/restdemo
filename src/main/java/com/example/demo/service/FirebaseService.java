package com.example.demo.service;

import com.example.demo.objects.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
    public String saveUserDetails(Person person){
        Firestore firestoreDb = FirestoreClient.getFirestore();

        try{
            ApiFuture<WriteResult> collectionsApiFuture = firestoreDb.collection("users").document(person.getName()).set(person);
            return collectionsApiFuture.get().getUpdateTime().toString();
        } catch (Exception e){
            e.printStackTrace();
            return "-1";
        }
    }
}
