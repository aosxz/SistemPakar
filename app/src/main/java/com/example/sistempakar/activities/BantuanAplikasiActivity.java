package com.example.sistempakar.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sistempakar.R;
import com.example.sistempakar.fragments.DiagnosaFragment;
import com.example.sistempakar.fragments.InfoKerusakanFragment;
import com.example.sistempakar.fragments.TentangAplikasiFragment;
import com.example.sistempakar.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

public class BantuanAplikasiActivity extends AppCompatActivity {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};

    ViewPager2 viewPager;
    SectionsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan_aplikasi);

        viewPager = findViewById(R.id.view_pager);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager(), getLifecycle());

        // add Fragments in your ViewPagerFragmentAdapter class

        adapter.addFragment(new InfoKerusakanFragment());
        adapter.addFragment(new DiagnosaFragment());
        adapter.addFragment(new TentangAplikasiFragment());

        // set the adapter to the ViewPager2
        viewPager.setAdapter(adapter);


        new TabLayoutMediator(findViewById(R.id.tabs), viewPager,
                (tab, position) -> tab.setText(TAB_TITLES[position])).attach();


    }
}