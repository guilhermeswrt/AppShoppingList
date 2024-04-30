package com.example.testeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.testeapp.adapter.ItemAdapter;
import com.example.testeapp.databinding.ActivityMainBinding;
import com.example.testeapp.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SelectListener {


    private ActivityMainBinding binding;
    private ItemAdapter itemAdapter;
    private ArrayList<Item> itemList = new ArrayList<>();

    private Button btnAddNew;
    private Button btnSave;
    private Button btnCleanAll;

    private EditText editTextName;
    private EditText editTextDescription;
    private EditText editTextQuantity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewItem = binding.RecyclerViewList;
        recyclerViewItem.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewItem.setHasFixedSize(true);
        itemAdapter = new ItemAdapter(itemList, this, this);
        recyclerViewItem.setAdapter(itemAdapter);
        btnAddNew = findViewById(R.id.btonAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout addNewLayout = findViewById(R.id.addNewLayout);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_add_new, addNewLayout);
                btnSave = view.findViewById(R.id.btnSave);
                editTextName = view.findViewById(R.id.editTextName);
                editTextDescription = view.findViewById(R.id.editTextDescription);
                editTextQuantity = view.findViewById(R.id.editTextQuantity);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(view);

                final AlertDialog alertDialog = builder.create();

                btnSave.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemList.add(new Item (
                                editTextName.getText().toString(),
                                editTextDescription.getText().toString(),
                                editTextQuantity.getText().toString(),
                                R.drawable.cart
                        ));
                        itemAdapter.notifyDataSetChanged();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
            }
        });

        btnCleanAll = findViewById(R.id.btnCleanAll);
        btnCleanAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.clear();
                itemAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onItemAddedToCart(int position) {
        Item editedItem = itemList.get(position);
        editedItem.setImgCart(R.drawable.cartcheck);
        itemList.set(position, editedItem);
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRemoved(int position) {
        itemList.remove(position);
        itemAdapter.notifyDataSetChanged();
    }
}