package com.example.myapplication;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser {

    DatabaseReference databaseReference;

    public DAOUser() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference= database.getReference(User.class.getSimpleName());


    }

    public Task<Void> add(User user){

        return databaseReference.push().setValue(user);

    }


}
