package com.example.myogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myogs.adapter.NewsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment_1 extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.recyclerviewxml, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewLaptop);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        List<News> allNewsInfo = getAllNewsInfo();
        NewsRecyclerViewAdapter newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(getContext(), allNewsInfo);
        recyclerView.setAdapter(newsRecyclerViewAdapter);

        return v;
    }

    private List<News> getAllNewsInfo(){

        List<News> allNews = new ArrayList<News>();

        allNews.add(new News("Best laptops at CES 2023: 3D OLED tech, new gaming laptops, and everything else", "⏲ 05 January 2023", R.drawable.news_bestlaptop));
        allNews.add(new News("Lenovo's Yoga Book 9i makes a case for dual-screen laptops, and it doesn't suck", "⏲ 06 January 2023", R.drawable.news_lenovoyoga));
        allNews.add(new News("Razer's Blade 16 and 18 gaming laptops pack serious power – and hefty price tags", "⏲ 07 January 2023", R.drawable.news_razerblade));
        allNews.add(new News("Intel Raptor Lake laptop CPU benchmark points to a multi-core monster", "⏲ 29 November 2022", R.drawable.news_intelraptor));
        allNews.add(new News("Chromebooks with AMD CPUs can now play Steam games – RIP gaming laptops?", "⏲ 04 November 2022", R.drawable.news_chromebookswithamd));


        return allNews;

    }

}
