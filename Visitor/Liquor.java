package com.company;

public class Liquor implements Visitable  {

    private double price;

    public Liquor(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Liquor{" +
                "price=" + price +
                '}';
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit( this);
    }

//    public double calcHolidayTax()
//    {
//
//    }
//
//    public double calcGovernmentTax()
//    {
//
//    }

}
