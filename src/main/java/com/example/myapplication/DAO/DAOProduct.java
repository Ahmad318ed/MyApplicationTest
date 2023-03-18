package com.example.myapplication.DAO;

import com.example.myapplication.Model.Product;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOProduct {

    DatabaseReference databaseReference;

    public DAOProduct() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference= database.getReference(Product.class.getSimpleName());


    }

    public Task<Void> add(Product product){

        return databaseReference.push().setValue(product);

    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){


      return   databaseReference.child(key).updateChildren(hashMap);

    }
    public Task<Void> remove(String key){

        return databaseReference.child(key).removeValue();
    }


}
