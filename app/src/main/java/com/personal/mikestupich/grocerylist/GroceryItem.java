package com.personal.mikestupich.grocerylist;

/**
 * Created by mikes on 2017-05-04.
 */

public class GroceryItem {
    private String itemName;
    private int itemCount;

    public GroceryItem(){

    }

    public GroceryItem(String name, int count){
        itemName = name;
        itemCount = count;
    }
    public String getItemName(){return itemName;}
    public String getItemCount(){return Integer.toString(itemCount);}
}
