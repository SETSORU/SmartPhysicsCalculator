package com.example.smartphysicscalculator.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.activities.CalculationActivity;
import com.example.smartphysicscalculator.ui.base.BaseFragment;

public class GravitationalForceFragment extends BaseFragment {

    private GravitationalForceViewModel mViewModel;
    private EditText et1, et2;
    private TextView tV;
    private Button btnCalculateGravForce;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.mass_for_gravitational_force);
        et2 = view.findViewById(R.id.grav_acc_for_gravitational_force);
        tV = view.findViewById(R.id.gravitational_force);
        btnCalculateGravForce = view.findViewById(R.id.btnCalculateGravForce);
        btnCalculateGravForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CalculationActivity.checkNumeric(et1.getText().toString()) && CalculationActivity.checkNumeric(et2.getText().toString())) {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double res = num1 * num2;
                    tV.setText(String.valueOf(res));
                    CalculationActivity.hideKeyboard(getActivity());
                } else {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static GravitationalForceFragment newInstance() {
        return new GravitationalForceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gravitational_force_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GravitationalForceViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "Смла тяжести (F)";
    }
}
