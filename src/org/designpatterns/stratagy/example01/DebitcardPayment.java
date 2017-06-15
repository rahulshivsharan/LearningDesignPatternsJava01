package org.designpatterns.stratagy.example01;

public class DebitcardPayment implements PaymentStratagy{

	private static final double DISCOUNT = 3.4;
	
	@Override
	public void payAmount(double amt) {
		// TODO Auto-generated method stub
		double amtPayment = amt - (amt * DISCOUNT/100);
		
		System.out.println(" Amount to be paid by DebitCard is  "+amtPayment);
	}

}
