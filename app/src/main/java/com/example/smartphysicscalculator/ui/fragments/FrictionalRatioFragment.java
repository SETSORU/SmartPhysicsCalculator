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

public class FrictionalRatioFragment extends BaseFragment {

    private FrictionalRatioViewModel mViewModel;
    private EditText et1, et2;
    private TextView tV;
    private Button btnCalculateFrictionalRatio;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.frictionalForce_for_frictionalRatio);
        et2 = view.findViewById(R.id.normalForce_for_frictionalRatio);
        tV = view.findViewById(R.id.frictionalRatio);
        btnCalculateFrictionalRatio = view.findViewById(R.id.btnCalculateFrictionalRatio);
        btnCalculateFrictionalRatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CalculationActivity.checkNumeric(et1.getText().toString()) && CalculationActivity.checkNumeric(et2.getText().toString())) {

                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double res = num1 / num2;
                    tV.setText(String.valueOf(res));
                    CalculationActivity.hideKeyboard(getActivity());
                } else {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static FrictionalRatioFragment newInstance() {
        return new FrictionalRatioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frictional_ratio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FrictionalRatioViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "Коэффициент трения (μ)";
    }
}
