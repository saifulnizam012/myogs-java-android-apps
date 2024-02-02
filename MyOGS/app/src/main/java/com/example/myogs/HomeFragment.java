package com.example.myogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment{

    ImageView oneNews;
    CardView cv12, cvS21, cv13, cvWebsiteNews, cvNews;
    CardView cvProfile, cvProducts, cvContact, cvAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        cv12 = v.findViewById(R.id.cv_ip12);
        cvS21 = v.findViewById(R.id.cv_s21);
        cv13 = v.findViewById(R.id.cv_ip13);
        cvWebsiteNews = v.findViewById(R.id.cv_interNews);
        cvNews = v.findViewById(R.id.cv_localNews);

        oneNews = v.findViewById(R.id.bestlaptopNews);

        cvProfile = v.findViewById(R.id.cv_profile);
        cvProducts = v.findViewById(R.id.cv_products);
        cvContact = v.findViewById(R.id.cv_contact);
        cvAbout = v.findViewById(R.id.cv_about);

        cv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(), Asus_rog.class));

            }
        });

        cv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(), Asus_tuf.class));

            }
        });

        cvS21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(), Asus_vivobook.class));

            }
        });

        cvWebsiteNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("https://www.pocket-lint.com/laptops/news/"));

                Toast.makeText(getContext(), "Directing to browser...", Toast.LENGTH_SHORT).show();
                startActivity(webIntent);

            }
        });

        cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), News_activity.class));

            }
        });

        oneNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(), News_Plus.class));

            }
        });

        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(), Profile_Page_Activity.class));
            }
        });

        cvProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new LaptopFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new ContactusFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new AboutusFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}
