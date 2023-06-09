package com.example.myapplication.DAO;

import com.example.myapplication.Model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOUser {

    DatabaseReference databaseReference;

    public DAOUser() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference= database.getReference(User.class.getSimpleName()).child("FirstGroup");


    }

    public Task<Void> add(User user){

        return databaseReference.push().setValue(user);

    }


    public Task<Void> update(String key, HashMap<String,Object> hashMap){


        return   databaseReference.child(key).updateChildren(hashMap);

    }
    public Task<Void> remove(String key){

        return databaseReference.child(key).removeValue();
    }

    public Query get(){


        return databaseReference.orderByKey();

    }


}
