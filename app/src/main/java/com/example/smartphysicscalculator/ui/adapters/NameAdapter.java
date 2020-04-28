package com.example.smartphysicscalculator.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;

import java.util.List;


public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    private List<RVName> names;
    private OnNameListener onNameListener;

    public NameAdapter( List<RVName> names, OnNameListener onNameListener) { this.names = names; this.onNameListener = onNameListener; }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_list, parent, false);
        return new NameViewHolder(view, onNameListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.onBind(names.get(position));
    }


    @Override
    public int getItemCount() {
        return names.size();
    }

    public interface OnNameListener{
        void onNameClick(int position);
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_item_name;
        OnNameListener onNameListener;

        public NameViewHolder(@NonNull View itemView, OnNameListener onNameListener) {
            super(itemView);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);
            this.onNameListener = onNameListener;
            itemView.setOnClickListener(this);
        }

        public void onBind(RVName name) {
            tv_item_name.setText(name.getName());
        }

        @Override
        public void onClick(View v) {
            onNameListener.onNameClick(getAdapterPosition());
        }
    }
}

