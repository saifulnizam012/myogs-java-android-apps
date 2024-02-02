package com.example.myogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myogs.adapter.LaptopRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class LaptopFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.recyclerviewxml, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewLaptop);
        linearLayoutManager = new LinearLayoutManager(getContext());
        //recyclerView.setLayoutManager(linearLayoutManager);

        List<Laptop> allPhonesInfo = getAllPhonesInfo();
        LaptopRecyclerViewAdapter laptopRecyclerViewAdapter = new LaptopRecyclerViewAdapter(getContext(), allPhonesInfo);
        recyclerView.setAdapter(laptopRecyclerViewAdapter);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);


        return v;
    }

    private List<Laptop> getAllPhonesInfo(){

        List<Laptop> allLaptop = new ArrayList<Laptop>();

        //acer
        allLaptop.add(new Laptop("Acer Chromebook 311", R.drawable.acer_chromebook_311));
        allLaptop.add(new Laptop("Acer Swift X", R.drawable.acer_swift_x));
        allLaptop.add(new Laptop("Acer Swift 3", R.drawable.acer_swift_3));
        allLaptop.add(new Laptop("Acer Everyday Aspire 3", R.drawable.acer_everyday_aspire_3));
        allLaptop.add(new Laptop("Acer Predator Helios 300", R.drawable.acer_predator_helios_300));

        //asus
        allLaptop.add(new Laptop("Asus ROG Strix G17", R.drawable.asus_rog_strix_g17));
        allLaptop.add(new Laptop("Asus ROG Strix G15", R.drawable.asus_rog_strix_g15));
        allLaptop.add(new Laptop("Asus TUF Gaming A17", R.drawable.asus_tuf_gaming_a17));
        allLaptop.add(new Laptop("Asus TUF Gaming A15", R.drawable.asus_tuf_gaming_a15));
        allLaptop.add(new Laptop("Asus Vivobook 15", R.drawable.asus_vivobook_15));

        //dell
        allLaptop.add(new Laptop("Dell XPS 15", R.drawable.dell_xps_15));
        allLaptop.add(new Laptop("Dell XPS 13 2in1", R.drawable.dell_xps_13_2in1));
        allLaptop.add(new Laptop("Dell Inspiron 14", R.drawable.dell_inspiron_14));
        allLaptop.add(new Laptop("Dell Inspiron 14 2in1", R.drawable.dell_inspiron_14_2in1));
        allLaptop.add(new Laptop("Dell Alienware x15 R2", R.drawable.dell_alienware_x15_r2));

        //lenovo
        allLaptop.add(new Laptop("Lenovo Legion 5", R.drawable.lenovo_legion_5));
        allLaptop.add(new Laptop("Lenovo Legion 7", R.drawable.lenovo_legion_7));
        allLaptop.add(new Laptop("Lenovo ThinkPad E15", R.drawable.lenovo_thinkpad_e15));
        allLaptop.add(new Laptop("Lenovo ThinkPad X13 Yoga", R.drawable.lenovo_thinkpad_x13_yoga));
        allLaptop.add(new Laptop("Lenovo IdeaPad 1", R.drawable.lenovo_ideapad_1));

        // hp
        allLaptop.add(new Laptop("Victus by HP", R.drawable.victus_by_hp));
        allLaptop.add(new Laptop("OMEN by HP", R.drawable.omen_by_hp));
        allLaptop.add(new Laptop("HP Pavilion Aero", R.drawable.hp_pavilion_aero));
        allLaptop.add(new Laptop("HP Laptop 15s", R.drawable.hp_15s));
        allLaptop.add(new Laptop("HP ENVY 16", R.drawable.hp_envy_16));


        return allLaptop;

    }

}
