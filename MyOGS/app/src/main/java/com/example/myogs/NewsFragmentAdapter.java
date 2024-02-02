package com.example.myogs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NewsFragmentAdapter extends FragmentStateAdapter {

    public NewsFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 1:
                return new NewsFragment_2();
        }

        return new NewsFragment_1();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

