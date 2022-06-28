package com.example.myapplication;

import android.content.Context;
//package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Game;
import com.example.myapplication.models.Item;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerRanking extends RecyclerView.Adapter<RecyclerRanking.MyViewHolder> {

    private List<Game> ItemList;
    private Context context;

    public RecyclerRanking(Context ct, List<Game> q){
        this.context = ct;
        ItemList = q;
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
        holder.name.setText("User: "+ItemList.get(position).getUsername());
        holder.date.setText("Date: "+ItemList.get(position).getDate());
        String points = String.valueOf("Score: "+ItemList.get(position).getPoints());
        holder.score.setText(points);
        Picasso.with(context).load(ItemList.get(position).getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
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
            score = (TextView) itemView.findViewById(R.id.textViewCount);
            avatar = (ImageView) itemView.findViewById(R.id.imageViewRecycler);
        }
    }
}
