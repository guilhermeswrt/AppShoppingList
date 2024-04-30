package com.example.testeapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeapp.SelectListener;
import com.example.testeapp.databinding.ActivityItemBinding;
import com.example.testeapp.model.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final ArrayList<Item> itemList;
    private final Context context;
    private SelectListener listener;
    public ItemAdapter(ArrayList<Item> itemList, Context context, SelectListener listener) {
        this.itemList = itemList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityItemBinding listItem;
        listItem = ActivityItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ItemViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.txtItemName.setText(itemList.get(position).getItemName());
        holder.binding.txtDescription.setText(itemList.get(position).getItemDescription());
        holder.binding.txtQuantity.setText(itemList.get(position).getItemQuantity());
        holder.binding.imgCart.setImageResource(itemList.get(position).getImgCart());

        holder.binding.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemAddedToCart(position);
            }
        });

        holder.binding.imgDump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ActivityItemBinding binding;
        public ItemViewHolder(ActivityItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
