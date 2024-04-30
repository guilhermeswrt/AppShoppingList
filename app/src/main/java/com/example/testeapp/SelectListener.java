package com.example.testeapp;

import com.example.testeapp.model.Item;

public interface SelectListener  {
    void onItemAddedToCart(int position);

    void onItemRemoved(int position);
}
