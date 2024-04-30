package com.example.testeapp.model;

public class Item {
    String itemName;
    String itemDescription;
    String itemQuantity;
    int imgCart;

    public void setImgCart(int imgCart) {
        this.imgCart = imgCart;
    }

    public Item(String itemName, String itemDescription, String itemQuantity, int imgCart) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.imgCart = imgCart;
    }

    public int getImgCart() {
        return imgCart;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

}
