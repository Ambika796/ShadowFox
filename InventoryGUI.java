package InventoryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InventoryGUI extends JFrame
{
    JTextField nameField;
    JTextField quantityField;
    JTextField priceField;

    JButton addButton;
    JButton updateButton;
    JButton deleteButton;

    JTable table;
    DefaultTableModel model;

    InventoryManager manager;


    public InventoryGUI()
    {
        manager = new InventoryManager();

        setTitle("Inventory Management System");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Top Panel
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(4,2));


        inputPanel.add(new JLabel("Item Name"));

        nameField = new JTextField();
        inputPanel.add(nameField);


        inputPanel.add(new JLabel("Quantity"));

        quantityField = new JTextField();
        inputPanel.add(quantityField);


        inputPanel.add(new JLabel("Price"));

        priceField = new JTextField();
        inputPanel.add(priceField);


        add(inputPanel,BorderLayout.NORTH);



        // Buttons

        JPanel buttonPanel = new JPanel();


        addButton = new JButton("Add");

        updateButton = new JButton("Update");

        deleteButton = new JButton("Delete");


        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);


        add(buttonPanel,BorderLayout.SOUTH);



        // Table

        model = new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");


        table = new JTable(model);


        add(new JScrollPane(table),
            BorderLayout.CENTER);



        // Add Button

        addButton.addActionListener(e ->
        {
            addItem();
        });



        // Update Button

        updateButton.addActionListener(e ->
        {
            updateItem();
        });



        // Delete Button

        deleteButton.addActionListener(e ->
        {
            deleteItem();
        });



        setVisible(true);
    }



    private void addItem()
    {
        String name =
            nameField.getText();


        int quantity =
            Integer.parseInt(quantityField.getText());


        double price =
            Double.parseDouble(priceField.getText());


        Item item =
            new Item(name,quantity,price);


        manager.addItem(item);


        displayItems();


        clearFields();
    }




    private void updateItem()
    {
        int row =
            table.getSelectedRow();


        if(row >= 0)
        {
            String name =
                nameField.getText();


            int quantity =
                Integer.parseInt(quantityField.getText());


            double price =
                Double.parseDouble(priceField.getText());


            Item item =
                new Item(name,quantity,price);


            manager.updateItem(row,item);


            displayItems();

            clearFields();
        }
    }





    private void deleteItem()
    {
        int row =
            table.getSelectedRow();


        if(row >= 0)
        {
            manager.deleteItem(row);

            displayItems();

            clearFields();
        }
    }





    private void displayItems()
    {
        model.setRowCount(0);


        for(Item item : manager.getItems())
        {
            model.addRow(
                new Object[]
                {
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice()
                }
            );
        }
    }




    private void clearFields()
    {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }




    public static void main(String args[])
    {
        new InventoryGUI();
    }
}