package com.example.myapplication.projectlab.Lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.projectlab.R;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private List<Module> moduleList;

    public ModuleAdapter(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.layoutlab5item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module module = moduleList.get(position);
        holder.imView.setImageResource(module.getImageId());
        holder.tvName.setText(module.getName());
        holder.tvDescription.setText(module.getDescription());
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imView;
        private TextView tvName;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imView = itemView.findViewById(R.id.itemImageView);
            tvName = itemView.findViewById(R.id.itemTextView);
            tvDescription = itemView.findViewById(R.id.itemDescriptionView);
        }
    }
}
