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

public class UniAccFirstVelocityFragment extends BaseFragment {

    private UniAccFirstVelocityViewModel mViewModel;
    private Button btnCalculateUniAccFirstVelocity;
    private EditText et1, et2, et3;
    private TextView tV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.velocity_for_firstVelocity);
        et2 = view.findViewById(R.id.acc_for_firstVelocity);
        et3 = view.findViewById(R.id.time_for_firstVelocity);
        tV = view.findViewById(R.id.uni_acc_firstVelocity);
        btnCalculateUniAccFirstVelocity = view.findViewById(R.id.btnCalculateUniAccFirstVelocity);
        btnCalculateUniAccFirstVelocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double num3 = Double.parseDouble(et3.getText().toString());
                double res = num1 - (num2 * num3);
                tV.setText(String.valueOf(res));
                CalculationActivity.hideKeyboard(getActivity());
            }
        });
    }

    public static UniAccFirstVelocityFragment newInstance() {
        return new UniAccFirstVelocityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.uni_acc_first_velocity_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UniAccFirstVelocityViewModel.class);
    }

    @Override
    public String getName() {
        return "НАЧАЛЬНАЯ СКОРОСТЬ (V)";
    }
}
