package com.company;

public class Tobacco implements Visitable {

    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "price=" + price +
                '}';
    }

    public Tobacco(double price) {
        this.price = price;
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
