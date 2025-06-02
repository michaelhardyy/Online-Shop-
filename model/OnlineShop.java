package model;

import java.util.*;
public class OnlineShop
{
    private Sellers sellers = new Sellers();
    private Items items = new Items();
    private int month = 0;
    private double balance = 0.0;
    private final char YES = 'Y';
    private final int SELL = 2;
    private double totalIncome = 0.0;
    public OnlineShop()
    {
        
    }

    public void addSeller(Seller newSeller)
    {
        sellers.add(newSeller);
      
    }
    
    public void addItem(Item newItem)
    {
        items.addItem(newItem);
       
    }
 
    public String report()
    {
        show();
        //sellers.show();
        //items.show();
        return sellers.show() + items.show();
    }

    private void exit()
    {
        
                System.out.println("Goodbye");

    }
    
    private void error()
    {
        System.out.println("No action found. Try again");
        
    }
    public void sellItems(int id)
    {
        items.sellItems(id);
        
    }
    private double income()
    {
        return items.income();
    }
    public void show()
    {
        System.out.println(toString());
    }
    public String toString(){
      String s = "Report of Online Shop:";
      
      return s;
    }
}
