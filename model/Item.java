package model;


public abstract class Item extends Record
{
    protected double price;
    protected String title;
    protected Seller seller;
    protected State state;
    protected final double ZERO = 0.0;
    protected int totalItem;
    private int itemAvailable= 100000;
    protected int itemSold;

    public Item(int id, double price,String title, int totalItem)
    {
        super(id, "Name");
        this.price = price;
        this.title = title;
        this.totalItem = totalItem;
        updateViews();
    }
    public void sellItems()
    {   
        int number = totalItem;
    
        if(number <= itemAvailable)
        {
            itemAvailable =- number;
            itemSold += number ;
            System.out.println("Items Sold!");
        }
        else
        {
            System.out.println("Items not available - Transaction Failed");;
        } 

    }
    public boolean matches(Seller seller)
    {
        return this.seller.equals(seller);
    }
    public abstract double income();
    
    public boolean isAvailable()
    {
        return state == State.AVAILABLE;
    }
    public String getState()
    {
        return state.toString();
    }
    public String toString()
    {
        return "Item ID" + super.toString()+ ": " + title + ", price $" + price;
    }
    
}
