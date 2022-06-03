package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.*;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<User> userList;
    private Context context;

    public RecyclerViewAdapter(Context ct, List<User> users){
        this.context = ct;

        userList = users;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler, parent, false);
        MyViewHolder v = new MyViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.username.setText(userList.get(position).getUsername());
        holder.name.setText(userList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{



        public TextView name;
        public TextView username;
        public View layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            username = (TextView) itemView.findViewById(R.id.textRecyclerUser);
            name = (TextView) itemView.findViewById(R.id.textRecyclerName);

        }
    }
}

