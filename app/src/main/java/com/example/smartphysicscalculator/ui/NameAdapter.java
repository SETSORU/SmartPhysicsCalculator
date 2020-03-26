package com.example.smartphysicscalculator.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;

import java.util.List;


public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {
    private List<RVName> names;

    public NameAdapter( List<RVName> names) { this.names = names; }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_list, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.onBind(names.get(position));
    }


    @Override
    public int getItemCount() {
        return names.size();
    }
}

