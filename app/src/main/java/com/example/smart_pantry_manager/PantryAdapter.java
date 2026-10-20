package com.example.smart_pantry_manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smart_pantry_manager.data.PantryItem;
import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {

    private List<PantryItem> pantryList;

    public PantryAdapter(List<PantryItem> pantryList) {
        this.pantryList = pantryList;
    }

    public void setPantryList(List<PantryItem> newList) {
        this.pantryList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = pantryList.get(position);
        holder.textName.setText(item.name);
        holder.textQuantity.setText(item.quantity + " " + item.unit);
    }

    @Override
    public int getItemCount() {
        return pantryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textItemName);
            textQuantity = itemView.findViewById(R.id.textItemQuantity);
        }
    }
}