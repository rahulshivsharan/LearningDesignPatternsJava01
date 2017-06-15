package org.designpatterns.stratagy.example01;

public class PayTmWalletPayment implements PaymentStratagy{
	
	private double totalWalletAmount;
	private static final double DISCOUNT = 3.6;
	
	public PayTmWalletPayment(double totalWalletAmount){
		this.totalWalletAmount = totalWalletAmount;
	}
	
	@Override
	public void payAmount(double amt) {
		amt -= this.totalWalletAmount;
		
		double amtPayment = amt - (amt * DISCOUNT/100);
		
		amtPayment = (amtPayment < 0) ? 0 : amtPayment;
		
		System.out.println(" Amount to be paid by PayTM is  "+amtPayment);
	}

}
