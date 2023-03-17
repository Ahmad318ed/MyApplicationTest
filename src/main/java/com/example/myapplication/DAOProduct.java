package com.example.myapplication;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOProduct {

    DatabaseReference databaseReference;

    public DAOProduct() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference= database.getReference(Product.class.getSimpleName());


    }

    public Task<Void> add(Product product){

        return databaseReference.push().setValue(product);

    }


}
