package com.example.myapplication.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class RecyclerFAQ extends RecyclerView.Adapter<RecyclerFAQ.MyViewHolder> {

    private List<FAQs> FAQList;
    private Context context;

    public RecyclerFAQ(Context ct, List<FAQs> users){
        this.context = ct;

        FAQList = users;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerfaqs, parent, false);
        MyViewHolder v = new MyViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.username.setText(FAQList.get(position).getPregunta());
        holder.name.setText(FAQList.get(position).getRespuesta());

    }

    @Override
    public int getItemCount() {
        return FAQList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{



        public TextView name;
        public TextView username;
        public View layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            username = (TextView) itemView.findViewById(R.id.PreguntaTextView);
            name = (TextView) itemView.findViewById(R.id.respuestaTextView);

        }
    }
}


