package com.kirabium.freelancefinder.service;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kirabium.freelancefinder.model.Freelance;

import java.util.ArrayList;
import java.util.List;


/**
 * I decided to apply the Singleton pattern to the repository, but you can also
 * inject it in your viewmodels from the ViewModel Factory, the most important
 * is to have a single instance of your repository in your app
 */
public class FreelanceRepository {
    private final MutableLiveData<List<Freelance>> listOfFreelance = new MutableLiveData<>();

    private static FreelanceRepository sFreelanceRepository;
    private final FirebaseHelper mFirebaseHelper;

    public static FreelanceRepository getInstance() {
        if (sFreelanceRepository == null) {
            sFreelanceRepository = new FreelanceRepository();
        }
        return sFreelanceRepository;
    }

    public FreelanceRepository() {
        mFirebaseHelper = FirebaseHelper.getInstance();
        // Uncomment this method to populate your firebase database, it will upload some data
        // Comment it again after the first launch
        // initData();
    }


    public MutableLiveData<List<Freelance>> getAllFreelances() {
        mFirebaseHelper.getAllFreelances().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Freelance> freelances = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    freelances.add(document.toObject(Freelance.class));
                }
                listOfFreelance.postValue(freelances);
            } else {
                Log.d("Error", "Error getting documents: ", task.getException());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //handle error
                listOfFreelance.postValue(null);
            }
        });
        return listOfFreelance;
    }

    public LiveData<List<Freelance>> getAllFreelancesSortedByTJM() {
        mFirebaseHelper.getAllFreelancesSortedByTJM().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Freelance> freelances = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    freelances.add(document.toObject(Freelance.class));
                }
                listOfFreelance.postValue(freelances);
            } else {
                Log.d("Error", "Error getting documents: ", task.getException());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //handle error
                listOfFreelance.postValue(null);
            }
        });
        return listOfFreelance;
    }

    public LiveData<List<Freelance>> getAllFreelancesSortedByCity() {
        mFirebaseHelper.getAllFreelancesSortedByCity().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<Freelance> freelances = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    freelances.add(document.toObject(Freelance.class));
                }
                listOfFreelance.postValue(freelances);
            } else {
                Log.d("Error", "Error getting documents: ", task.getException());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //handle error
                listOfFreelance.postValue(null);
            }
        });
        return listOfFreelance;
    }

    private void initData() {
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("https://avatars.githubusercontent.com/u/32424601?s=400&u=22568998290937ae2a2a682654e5af68cbfe27fd&v=4", "Virgile", "Fantauzzi", "Lyon", 400, 55, 4));
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("https://brandandcelebrities.com/wp-content/uploads/2017/04/Franck_Dubosc.jpg", "Franck", "Dubosc", "Paris", 500, 55, 5));
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("https://www.avcesar.com/source/actualites/00/00/74/25/la-vraie-vie-de-dwayne-the-rock-johnson-avant-le-cinema_prev_01014840.jpg", "The ROCK", "Jhonson", "New York", 800, 55, 2));
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("data:image/jpeg;base64,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", "Spiderman", "Dubosc", "Washington", 300, 55, 5));
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Batman_%28black_background%29.jpg/1024px-Batman_%28black_background%29.jpg", "Batman", "Dubosc", "Gotham", 200, 55, 1));
        FirebaseHelper.getInstance().freelancesRef.add(new Freelance("https://www.sortiraparis.com/images/80/66131/596236-fortnite-comment-debloquer-iron-man-le-guide-des-defis.jpg", "Tony", "Stark", "Paris", 1000, 55, 8));
    }
}
