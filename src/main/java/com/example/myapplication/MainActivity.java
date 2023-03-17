package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name,phone;
    Button btn_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.Name_et);
        phone=findViewById(R.id.Phone_et);
        btn_sub=findViewById(R.id.btn_submit);
        DAOUser daoUser=new DAOUser();
        DAOProduct daoProduct=new DAOProduct();
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Product product=new Product(name.getText().toString(),"Cards",phone.getText().toString());
                daoProduct.add(product).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(MainActivity.this, "Successfully Inserted to Db(:", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this, "Failed Insert to Db):", Toast.LENGTH_SHORT).show();


                    }
                });



            }
        });


    }
}