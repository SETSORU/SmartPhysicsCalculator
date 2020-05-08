package com.example.smartphysicscalculator.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.adapters.SectionsPagerAdapter;
import com.example.smartphysicscalculator.ui.fragments.DisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.TimeFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccFirstVelocityFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccTimeFragment;
import com.example.smartphysicscalculator.ui.fragments.UniAccVelocityFragment;
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
                sectionsPagerAdapter.setList(Arrays.asList(UniAccVelocityFragment.newInstance(), UniAccFirstVelocityFragment.newInstance(), UniAccFragment.newInstance(), UniAccTimeFragment.newInstance()));
                break;
            }

        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);
    }

    public void onDisplacementClick(View view) {
        EditText et1 = findViewById(R.id.velocity_for_displacement);
        EditText et2 = findViewById(R.id.time_for_displacement);
        TextView tV = findViewById(R.id.displacement);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double res = num1 * num2;
        tV.setText(Double.toString(res));
    }

    public void onTimeClick(View view) {
        EditText et1 = findViewById(R.id.displacement_for_time);
        EditText et2 = findViewById(R.id.velocity_for_time);
        TextView tV = findViewById(R.id.time);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double res = num1 / num2;
        tV.setText(Double.toString(res));
    }

    public void onVelocityClick(View view) {
        EditText et1 = findViewById(R.id.displacement_for_velocity);
        EditText et2 = findViewById(R.id.time_for_velocity);
        TextView tV = findViewById(R.id.velocity);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double res = num1 / num2;
        tV.setText(Double.toString(res));
    }

}