package InventoryManagementSystem;

import java.util.ArrayList;

public class InventoryManager
{
    private ArrayList<Item> items;


    public InventoryManager()
    {
        items = new ArrayList<>();
    }


    // Add Item
    public void addItem(Item item)
    {
        items.add(item);
    }


    // Get all items
    public ArrayList<Item> getItems()
    {
        return items;
    }


    // Update Item
    public void updateItem(int index, Item item)
    {
        items.set(index, item);
    }


    // Delete Item
    public void deleteItem(int index)
    {
        items.remove(index);
    }
}