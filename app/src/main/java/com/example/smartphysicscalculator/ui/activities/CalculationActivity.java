package com.example.smartphysicscalculator.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.adapters.SectionsPagerAdapter;
import com.example.smartphysicscalculator.ui.fragments.AccDisFirstVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.AccDisSecondVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.AccDisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.DisAccelerationFragment;
import com.example.smartphysicscalculator.ui.fragments.DisTimeFragment;
import com.example.smartphysicscalculator.ui.fragments.DisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeDisFirstVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeDisFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeDisSecondVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccDisplacementAccelerationFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccDisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccDisplacementTimeFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccDisplacementVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.VelocityFragment;
import com.google.android.material.tabs.TabLayout;

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
                sectionsPagerAdapter.setList(Arrays.asList(UniAccDisplacementFragment.newInstance(), UniAccDisplacementVelocityFragment.newInstance(), UniAccDisplacementAccelerationFragment.newInstance(), UniAccDisplacementTimeFragment.newInstance()));
                break;
            }
            case 2: {
                sectionsPagerAdapter.setList(Arrays.asList(TimeDisFragment.newInstance(), TimeDisFirstVelocityFragment.newInstance(), TimeDisSecondVelocityFragment.newInstance(), DisTimeFragment.newInstance()));
                break;
            }
            case 3: {
                sectionsPagerAdapter.setList(Arrays.asList(AccDisplacementFragment.newInstance(), AccDisFirstVelocityFragment.newInstance(), AccDisSecondVelocityFragment.newInstance(), DisAccelerationFragment.newInstance()));
                break;
            }

        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);
    }
}