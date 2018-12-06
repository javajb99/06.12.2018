package com.company;

public class NatbagTax implements Visitor {

	@Override
	public double visit(Liquor liqourItem) {
		return liqourItem.getPrice() * 0.90;
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		return tobaccoItem.getPrice() * 0.75;
	}
	

}
