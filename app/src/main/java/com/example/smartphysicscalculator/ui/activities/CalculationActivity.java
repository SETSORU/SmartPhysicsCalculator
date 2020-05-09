package com.example.smartphysicscalculator.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.adapters.SectionsPagerAdapter;
import com.example.smartphysicscalculator.ui.fragments.DisplacementFragment;
import com.example.smartphysicscalculator.ui.fragments.ForceAccFragment;
import com.example.smartphysicscalculator.ui.fragments.ForceFragment;
import com.example.smartphysicscalculator.ui.fragments.GravitationalAccFragment;
import com.example.smartphysicscalculator.ui.fragments.GravitationalForceFragment;
import com.example.smartphysicscalculator.ui.fragments.GravitationalMassFragment;
import com.example.smartphysicscalculator.ui.fragments.MassFragment;
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
            case 2: {
                sectionsPagerAdapter.setList(Arrays.asList(ForceFragment.newInstance(), MassFragment.newInstance(), ForceAccFragment.newInstance()));
                break;
            }
            case 3: {
                sectionsPagerAdapter.setList(Arrays.asList(GravitationalForceFragment.newInstance(), GravitationalMassFragment.newInstance(), GravitationalAccFragment.newInstance()));
            }
            case 4: {
                //sectionsPagerAdapter.setList(Arrays.asList(FrictionalForceFragment.newInstance(), FrictionalRatioFragment.newInstance(), ));
            }

        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onMassClick(View view) {


    }

    public void onGravForceClick(View view) {
        EditText et1 = findViewById(R.id.mass_for_gravitational_force);
        EditText et2 = findViewById(R.id.grav_acc_for_gravitational_force);
        TextView tV = findViewById(R.id.gravitational_force);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double res = num1 * num2;
        tV.setText(Double.toString(res));
    }

    public void onGravMassClick(View view) {
        EditText et1 = findViewById(R.id.gravitational_force_for_mass);
        EditText et2 = findViewById(R.id.gravitational_acc_for_mass);
        TextView tV = findViewById(R.id.gravitational_mass);

    }

    public void onGravAccClick(View view) {
        EditText et1 = findViewById(R.id.grav_force_for_grav_acc);
        EditText et2 = findViewById(R.id.mass_for_grav_acc);
        TextView tV = findViewById(R.id.gravitational_acc);
        double num1 = Double.parseDouble(et1.getText().toString());
        double num2 = Double.parseDouble(et2.getText().toString());
        double res = num1 / num2;
        tV.setText(Double.toString(res));
    }

    public void onForceClick(View view) {


    }
}