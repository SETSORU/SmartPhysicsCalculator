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

public class UniAccVelocityFragment extends BaseFragment {

    private UniAccVelocityViewModel mViewModel;
    private Button btnCalculateUniAccVelocity;
    private EditText et1, et2, et3;
    private TextView tV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.firstVelocity_for_velocity);
        et2 = view.findViewById(R.id.acc_for_velocity);
        et3 = view.findViewById(R.id.time_for_velocity1);
        tV = view.findViewById(R.id.uni_acc_velocity);
        btnCalculateUniAccVelocity = view.findViewById(R.id.btnCalculateUniAccVelocity);
        btnCalculateUniAccVelocity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double num3 = Double.parseDouble(et3.getText().toString());
                double res = num1 + (num2 * num3);
                tV.setText(Double.toString(res));
                CalculationActivity.hideKeyboard(getActivity());
            }
        });
    }

    public static UniAccVelocityFragment newInstance() {
        return new UniAccVelocityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.uni_acc_velocity_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UniAccVelocityViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "СКОРОСТЬ (V)";
    }
}
