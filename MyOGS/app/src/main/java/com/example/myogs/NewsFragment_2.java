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

public class NewsFragment_2 extends Fragment {

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

        List<News> allNewsInfo = getAllNewsLocalInfo();
        NewsRecyclerViewAdapter newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(getContext(), allNewsInfo);
        recyclerView.setAdapter(newsRecyclerViewAdapter);

        return v;
    }

    private List<News> getAllNewsLocalInfo(){

        List<News> allNews = new ArrayList<News>();

        allNews.add(new News("Deal: Honor MagicBook 14 and 15 are now going for less than RM1,800", "⏲ 26 November 2022", R.drawable.news_honormagicbook));
        allNews.add(new News("Vivobook 16X: Asus Malaysia’s affordable 16″ Ryzen 5 laptop, priced under RM3,000", "⏲ 12 October 2022", R.drawable.news_vivobook));
        allNews.add(new News("MSI GE76 Raider Malaysia review: Alder Lake is good, actually", "⏲ 02 September 2022", R.drawable.news_msigeraider));
        allNews.add(new News("HP Envy 16 Malaysia: 12th-gen Core processors, RTX 3060 graphics and 120Hz display, priced from RM6,999", "⏲ 29 July 2022", R.drawable.news_hpenvy));
        allNews.add(new News("HP Spectre x360 13.5 Malaysia: 2-in-1 laptop with 12th-gen Intel Core i7, priced from RM7,199", "⏲ 28 July 2022", R.drawable.news_hpspectre));


        return allNews;

    }

}
