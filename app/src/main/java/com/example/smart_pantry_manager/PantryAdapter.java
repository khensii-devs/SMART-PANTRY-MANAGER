package com.example.smart_pantry_manager;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smart_pantry_manager.data.AppDatabase;
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

        // TAP TO EDIT (UPDATE)
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AddEditItemActivity.class);
            intent.putExtra("ITEM_ID", item.id); // Pass the ID of the item we clicked
            v.getContext().startActivity(intent);
        });

        // LONG PRESS TO DELETE (DELETE)
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(holder.itemView.getContext())
                    .setTitle("Delete Item")
                    .setMessage("Are you sure you want to delete " + item.name + "?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        AppDatabase db = AppDatabase.getInstance(holder.itemView.getContext());
                        db.pantryDao().delete(item);
                        pantryList.remove(position);
                        notifyItemRemoved(position);
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        });
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