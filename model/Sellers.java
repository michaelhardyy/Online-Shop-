package model;

import java.util.*;
public class Sellers extends Records
{
    public Sellers()
    {
        
    }
    public void add(Seller newSeller)
    {
        super.add(newSeller);
        updateViews();
    } 
    public String show()
    {
        return super.show();
        
    }
    
}