package com.example.smartphysicscalculator.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.activities.CalculationActivity;
import com.example.smartphysicscalculator.ui.base.BaseFragment;

public class ForceAccFragment extends BaseFragment {

    private ForceAccViewModel mViewModel;
    private EditText et1, et2;
    private TextView tV;
    private Button btnCalculateForceAcc;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.force_for_acc);
        et2 = view.findViewById(R.id.mass_for_acc);
        tV = view.findViewById(R.id.acceleration);
        btnCalculateForceAcc = view.findViewById(R.id.btnCalculateForceAcc);
        btnCalculateForceAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double res = num1 / num2;
                tV.setText(String.valueOf(res));
                CalculationActivity.hideKeyboard(getActivity());
            }
        });
    }

    public static ForceAccFragment newInstance() {
        return new ForceAccFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.force_acc_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ForceAccViewModel.class);
    }

    @Override
    public String getName() {
        return "Ускорение (a)";
    }
}
