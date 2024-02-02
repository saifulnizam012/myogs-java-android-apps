package com.example.myogs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myogs.Laptop;
import com.example.myogs.Laptop_Detail_Activity;
import com.example.myogs.R;

import java.util.List;

public class LaptopRecyclerViewAdapter extends RecyclerView.Adapter<LaptopRecyclerViewAdapter.LaptopViewHolder> implements Filterable {

    public List<Laptop> laptopList;
    private Context context;


    public LaptopRecyclerViewAdapter(Context context, List<Laptop>laptopList) {
        this.context = context;
        this.laptopList = laptopList;

    }
    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View laptop_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.laptop_row, null);
        LaptopViewHolder LaptopVH = new LaptopViewHolder(laptop_row);

        return LaptopVH;
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {

        holder.tvLaptopName.setText(laptopList.get(position).getName());
        holder.imgViewLaptopImage.setImageResource(laptopList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public  class LaptopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvLaptopName;
        public ImageView imgViewLaptopImage;

        public LaptopViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLaptopName = itemView.findViewById(R.id.tv_laptopName);
            imgViewLaptopImage = itemView.findViewById(R.id.iv_laptop);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Laptops Name: " + laptopList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(view.getContext(), Laptop_Detail_Activity.class);
            intent.putExtra("laptopName", laptopList.get(getAdapterPosition()).getName());
            intent.putExtra("laptopPrice", laptopList.get(getAdapterPosition()).getImage());
            view.getContext().startActivity(intent);


        }
    }

}

