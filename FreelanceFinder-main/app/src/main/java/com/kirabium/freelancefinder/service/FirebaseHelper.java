package com.kirabium.freelancefinder.service;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseHelper {
    private static FirebaseHelper sFirebaseHelper;

    public static FirebaseHelper getInstance() {
        if (sFirebaseHelper == null) {
            sFirebaseHelper = new FirebaseHelper();
        }
        return sFirebaseHelper;
    }
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    public final CollectionReference freelancesRef = db.collection("freelances");

    public Task<QuerySnapshot> getAllFreelances(){
        return freelancesRef.get();
    }

    public Task<QuerySnapshot> getAllFreelancesSortedByCity() {
        return freelancesRef.orderBy("city").get();
    }
    public Task<QuerySnapshot> getAllFreelancesSortedByTJM() {
        return freelancesRef.orderBy("tjm").get();
    }
}
