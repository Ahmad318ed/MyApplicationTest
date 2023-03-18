package com.example.myapplication.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView tv_name,tv_phone;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_name=itemView.findViewById(R.id.name_tv);
        tv_phone=itemView.findViewById(R.id.phone_tv);


    }
}
