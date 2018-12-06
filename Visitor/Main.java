package com.company;

public class Main {

    public static void main(String[] args) {

        Tobacco marlboro = new Tobacco(30);
        Liquor vodka = new Liquor(250);

        Visitor holidayTax = new HolidayTax();
        System.out.println( marlboro.getPrice());
        System.out.println( marlboro.accept( holidayTax) );

        Visitor taxGov = new TaxGovernment();
        System.out.println( vodka.getPrice());
        System.out.println( vodka.accept( taxGov) );

        
        Visitor natbagDiscount = new NatbagTax();
        System.out.println( vodka.getPrice());
        System.out.println( vodka.accept(natbagDiscount) );
        System.out.println( vodka.accept( new Visitor() {

			@Override
			public double visit(Liquor liqourItem) {
				return liqourItem.getPrice() *0.5;
			}

			@Override
			public double visit(Tobacco tobaccoItem) {
				// TODO Auto-generated method stub
				return 0;
			}
        	
        }) );
    }
}
