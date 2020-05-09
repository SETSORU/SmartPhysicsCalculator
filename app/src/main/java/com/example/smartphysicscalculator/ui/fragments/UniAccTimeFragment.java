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
import com.example.smartphysicscalculator.ui.base.BaseFragment;

public class UniAccTimeFragment extends BaseFragment {

    private UniAccTimeViewModel mViewModel;
    private Button btnCalculateUniAccTime;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCalculateUniAccTime = view.findViewById(R.id.btnCalculateUniAccTime);
        btnCalculateUniAccTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = v.findViewById(R.id.velocity_for_time1);
                EditText et2 = v.findViewById(R.id.firstVelocity_for_time);
                EditText et3 = v.findViewById(R.id.acc_for_time);
                TextView tV = v.findViewById(R.id.uni_acc_time);
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double num3 = Double.parseDouble(et3.getText().toString());
                double res = (num1 - num2) / num3;
                tV.setText(Double.toString(res));
            }
        });
    }

    public static UniAccTimeFragment newInstance() {
        return new UniAccTimeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.uni_acc_time_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UniAccTimeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "ВРЕМЯ (t)";
    }
}
