package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.myapplication.Adapters.RVadapter;
import com.example.myapplication.DAO.DAOUser;
import com.example.myapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RvActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RVadapter rVadapter;
    RecyclerView recyclerView;
    DAOUser daoUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        swipeRefreshLayout=findViewById(R.id.swip);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        rVadapter=new RVadapter(this);
        recyclerView.setAdapter(rVadapter);

        daoUser=new DAOUser();

        loaddata();

    }

    private void loaddata() {

        daoUser.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<User>arrayList=new ArrayList<>();
                for(DataSnapshot data :snapshot.getChildren()){

                    User user=data.getValue(User.class);

                    arrayList.add(user);

                }
                rVadapter.setitems(arrayList);
                rVadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}