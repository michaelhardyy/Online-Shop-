package model;

public class SaleItem extends Item
{
    private String buyer;
    public SaleItem(int id, double price, String title, int totalItem)
    {
        super(id, price, title, totalItem);
        state = State.AVAILABLE;
        updateViews();
    }
    public double income()
    {
        if(isAvailable()){
        double totalIncome = price * totalItem;
        return totalIncome;
    }
        else{
            return ZERO;
        }
    }
    
}
