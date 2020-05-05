package com.example.smartphysicscalculator.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void onUniAccDisplacement(View view) {
        EditText et1 = findViewById(R.id.firstVelocity_for_uni_acc_dis);
        EditText et2 = findViewById(R.id.acc_for_uni_acc_dis);
        EditText et3 = findViewById(R.id.time_for_uni_acc_dis);
        TextView tV = findViewById(R.id.uni_displacement);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double num3 = Double.parseDouble(et3.getText().toString());
    }

    public void onUniAccDisAccelerationClick(View view) {
        EditText et1 = findViewById(R.id.uni_acc_dis_for_acceleration);
        EditText et2 = findViewById(R.id.uni_acc_firstVelocity_for_acceleration);
        EditText et3 = findViewById(R.id.uni_acc_time_for_acceleration);
        TextView tV = findViewById(R.id.uni_acceleration);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double num3 = Double.parseDouble(et3.getText().toString());
    }

    public void onUniAccDisTimeClick(View view) {
        EditText et1 = findViewById(R.id.uni_acc_dis_for_time);
        EditText et2 = findViewById(R.id.uni_acc_firstVelocity_for_time);
        EditText et3 = findViewById(R.id.uni_acc_acc_for_time);
        TextView tV = findViewById(R.id.uni_time);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double num3 = Double.parseDouble(et3.getText().toString());
    }

    public void onUniAccDisFirstVelocityClick(View view) {
        EditText et1 = findViewById(R.id.uni_acc_dis_for_firstVelocity);
        EditText et2 = findViewById(R.id.uni_acc_acc_for_firstVelocity);
        EditText et3 = findViewById(R.id.uni_acc_time_for_firstVelocity);
        TextView tV = findViewById(R.id.uni_firstVelocity);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double num3 = Double.parseDouble(et3.getText().toString());
    }
}