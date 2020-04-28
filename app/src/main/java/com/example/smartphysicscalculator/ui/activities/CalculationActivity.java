package com.example.smartphysicscalculator.ui.activities;

import android.os.Bundle;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.base.BaseFragment;
import com.example.smartphysicscalculator.ui.fragments.DisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeFragment;
import com.example.smartphysicscalculator.ui.fragments.VelocityFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.smartphysicscalculator.ui.adapters.SectionsPagerAdapter;

import java.util.Arrays;

public class CalculationActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY = "KEY_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        int key = getIntent().getIntExtra(KEY_ACTIVITY, -1);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        switch (key) {
            case 0: {
                sectionsPagerAdapter.setList(Arrays.asList(DisplacementFragment.newInstance(), VelocityFragment.newInstance(), TimeFragment.newInstance()));
                break;
            }
            case 1: {
                sectionsPagerAdapter.setList(Arrays.<BaseFragment>asList(DisplacementFragment.newInstance(), DisplacementFragment.newInstance(),DisplacementFragment.newInstance()));
                break;
            }
        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);


    }
}