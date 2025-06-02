package model;

public class Seller extends Record
{
    private String name;

    public Seller(int id, String name)
    {
        super(id, "name");
        this.name = name;
        updateViews();
    }
    public String toString()
    {
        return "Seller" + super.toString() + ": " + name;
    }
    
}