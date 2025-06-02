package model;

import java.util.*;
public class Items extends Records
{
    private final int SELL = 2;
    public Items()
    {
        
    }

    public void addItem(Item newItem)
    {
        super.add(newItem);
        updateViews();
    }

    public void sellItems(int id)
    {
        System.out.println("Sell Items");
        
         Item item = find(id);
        if (item == null)
        {
            System.out.println("Item Not Found");
        }
        else
        {
            item.sellItems();
        }
        updateViews();
    }

    public double income()
    {
        double income = 0.0;
        for (Record record : records)
        {
            income += ((Item)record).income();
        }
        return income;
    }

    public Item find(int id)
    {   
        return (Item) super.find(id);    
    }

    public String show()
    {
        return super.show();
        
    }
    
    public double getTotalSales() {
        double totalSales = 0.0;
        
        for (Record record : records) {
            SaleItem saleItem = (SaleItem) record;
            totalSales += saleItem.income();
        }
        
        return totalSales;
    }


    public String toString() {
        String s = "";
        for (Record record : records)
        s += "\n" + record.toString();
        s += "\nTotal Income: $" + income();
        return s;
    }
}

