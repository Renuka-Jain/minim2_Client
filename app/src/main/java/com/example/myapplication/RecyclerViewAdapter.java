package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Stats;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Stats> StatsList;
    private Context context;

    public RecyclerViewAdapter(Context ct, List<Stats> stats){
        this.context = ct;

        StatsList = stats;
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
        holder.name.setText("User: " + StatsList.get(position).getUser());
        holder.date.setText("Date: " + StatsList.get(position).getDate());
        String points = "Score: " + String.valueOf(StatsList.get(position).getScore());
        holder.score.setText(points);
        Picasso.with(context).load(StatsList.get(position).getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return StatsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView date;
        public TextView name;
        public TextView score;
        public View layout;
        public ImageView avatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            date = (TextView) itemView.findViewById(R.id.textRecyclerDATE);
            name = (TextView) itemView.findViewById(R.id.textRecyclerName);
            score = (TextView) itemView.findViewById(R.id.textViewRecyclerScore);
            avatar = (ImageView) itemView.findViewById(R.id.imageViewRecycler);

        }
    }
}

