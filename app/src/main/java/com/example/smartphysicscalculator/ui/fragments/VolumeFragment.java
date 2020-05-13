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

public class VolumeFragment extends BaseFragment {

    private VolumeViewModel mViewModel;
    private Button btnCalculateVolume;
    private EditText et1, et2, et3;
    private TextView tV;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.archimedesForce_for_volume);
        et2 = view.findViewById(R.id.archimedesGravAcc_for_volume);
        et3 = view.findViewById(R.id.density_for_volume);
        tV = view.findViewById(R.id.volume);
        btnCalculateVolume = view.findViewById(R.id.btnCalculateVolume);
        btnCalculateVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CalculationActivity.checkNumeric(et1.getText().toString()) && CalculationActivity.checkNumeric(et2.getText().toString()) && CalculationActivity.checkNumeric(et3.getText().toString())) {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double num3 = Double.parseDouble(et3.getText().toString());
                    double res = num1 / (num2 * num3);
                    tV.setText(String.valueOf(res));
                    CalculationActivity.hideKeyboard(getActivity());
                } else {
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static VolumeFragment newInstance() {
        return new VolumeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.volume_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VolumeViewModel.class);
    }

    @Override
    public String getName() {
        return "Объем (V)";
    }
}
