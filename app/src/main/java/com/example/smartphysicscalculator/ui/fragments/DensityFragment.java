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

public class DensityFragment extends BaseFragment {

    private DensityViewModel mViewModel;
    private Button btnCalculateDensity;
    private EditText et1, et2, et3;
    private TextView tV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.archimedesForce_for_density);
        et2 = view.findViewById(R.id.archimedesGravAcc_for_density);
        et3 = view.findViewById(R.id.volume_for_density);
        tV = view.findViewById(R.id.density);
        btnCalculateDensity = view.findViewById(R.id.btnCalculateDensity);
        btnCalculateDensity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double num3 = Double.parseDouble(et3.getText().toString());
                double res = num1 / (num2 * num3);
                tV.setText(String.valueOf(res));
                CalculationActivity.hideKeyboard(getActivity());
            }
        });
    }

    public static DensityFragment newInstance() {
        return new DensityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.density_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DensityViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "Плотность (ρ)";
    }
}
