package com.personal.mikestupich.grocerylist;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<GroceryItem> list;
    private String uID;

    public GroceryList(){

    }

    public GroceryList(ArrayList<GroceryItem> l){
        list.addAll(l);
    }

    public void addToList(GroceryItem item){
        list.add(item);
    }

    public boolean removeFromList(GroceryItem item){
        if (list.contains(item)){
            return list.remove(item);
        }
        return false;
    }

    public int getListSize(){
        return list.size();
    }

}
