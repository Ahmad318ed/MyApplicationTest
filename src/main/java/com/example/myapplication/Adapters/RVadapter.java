package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    ArrayList<User> listuser =new ArrayList<>();
    public RVadapter(Context context) {
        this.context=context;
    }

    public void setitems(ArrayList<User> user){

      listuser.addAll(user);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false);

       return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        UserViewHolder viewHolder=(UserViewHolder) holder;

        User user=listuser.get(position);
        viewHolder.tv_name.setText(user.getName());
        viewHolder.tv_phone.setText(user.getPhone());

    }

    @Override
    public int getItemCount() {
        return listuser.size();
    }
}
