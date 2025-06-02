package model;

import java.util.*;

public class Records extends Updater
{
    protected int id = 0;
    protected LinkedList<Record> records = new LinkedList<Record>();
    public Records()
    {
    }
    public void add(Record record)
    {
        records.add(record);   
        System.out.println(record.toString() + " added");
    }
    public Record find(int id)
    {   
        for (Record record : records)
        {   
            if (record.matches(id))
                return record;  
        }
        return null;    
    }
    public String show()
    {
       return toString();
    }
    public int getSize() {
        return records.size();
    }
    public String toString()
    {
        String s = "";
        for (Record record : records)
            s += "\n" + record.toString();
        return s;
    }
}
