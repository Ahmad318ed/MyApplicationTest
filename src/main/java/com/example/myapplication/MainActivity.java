package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DAO.DAOProduct;
import com.example.myapplication.DAO.DAOUser;
import com.example.myapplication.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name,phone;
    Button btn_sub,btn_open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.Name_et);
        phone=findViewById(R.id.Phone_et);
        btn_sub=findViewById(R.id.btn_submit);
        btn_open=findViewById(R.id.btn_open);

        DAOUser daoUser=new DAOUser();
        DAOProduct daoProduct=new DAOProduct();


        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                HashMap<String,Object>hashMap=new HashMap<>();
//                hashMap.put("name",name.getText().toString());
//                hashMap.put("type","Cards");
//                hashMap.put("price",phone.getText().toString());


                User user=new User(name.getText().toString(),phone.getText().toString());
                daoUser.add(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(MainActivity.this, "Successfully  to Db(:", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this, "Failed Insert to Db):", Toast.LENGTH_SHORT).show();


                    }
                });



            }
        });

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,RvActivity.class));

            }
        });


    }
}