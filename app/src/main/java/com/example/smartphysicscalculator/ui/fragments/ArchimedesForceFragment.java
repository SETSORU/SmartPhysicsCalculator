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

public class ArchimedesForceFragment extends BaseFragment {

    private ArchimedesForceViewModel mViewModel;
    private Button btnCalculateArchimedesForce;
    private EditText et1, et2, et3;
    private TextView tV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.density_for_archimedesForce);
        et2 = view.findViewById(R.id.grav_acc_for_archimedesForce);
        et3 = view.findViewById(R.id.volume_for_archimedesForce);
        tV = view.findViewById(R.id.archimedesForce);
        btnCalculateArchimedesForce = view.findViewById(R.id.btnCalculateArchimedesForce);
        btnCalculateArchimedesForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et1.getText().toString());
                double num2 = Double.parseDouble(et2.getText().toString());
                double num3 = Double.parseDouble(et3.getText().toString());
                double res = num1 * num2 * num3;
                tV.setText(String.valueOf(res));
                CalculationActivity.hideKeyboard(getActivity());
            }
        });
    }


    public static ArchimedesForceFragment newInstance() {
        return new ArchimedesForceFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.archimedes_force_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ArchimedesForceViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public String getName() {
        return "Сила Архимеда (F)";
    }
}
