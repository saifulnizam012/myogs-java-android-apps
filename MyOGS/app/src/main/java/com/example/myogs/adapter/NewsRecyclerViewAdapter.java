package com.example.myogs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myogs.News;
import com.example.myogs.R;
import com.example.myogs.News_Detail_Activity;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {

    public List<News> newsList;
    private Context context;

    public NewsRecyclerViewAdapter(Context context, List<News>newsList) {
        this.context = context;
        this.newsList = newsList;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View news_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, null);
        NewsViewHolder NewsVH = new NewsViewHolder(news_row);

        return NewsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.NewsViewHolder holder, int position) {

        holder.tvNewsName.setText(newsList.get(position).getName());
        holder.imgViewNewsImage.setImageResource(newsList.get(position).getImage());
        holder.tvNewsDate.setText(newsList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public  class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvNewsName, tvNewsDate;
        public ImageView imgViewNewsImage;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNewsName = itemView.findViewById(R.id.tv_newsName);
            imgViewNewsImage = itemView.findViewById(R.id.iv_news);
            tvNewsDate = itemView.findViewById(R.id.tv_newsDate);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "News: " + newsList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(view.getContext(), News_Detail_Activity.class);
            intent.putExtra("newsName", newsList.get(getAdapterPosition()).getName());
            intent.putExtra("newsDate", newsList.get(getAdapterPosition()).getDate());
            intent.putExtra("newsImage", newsList.get(getAdapterPosition()).getImage());
            view.getContext().startActivity(intent);
        }
    }

}