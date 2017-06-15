package org.designpatterns.stratagy.example01;

public class CreditcardPayment implements PaymentStratagy{

	private static final double DISCOUNT = 4;
	private Integer totalPointsEarned = 0;
	
	
	public CreditcardPayment(Integer pointsEarned){
		this.totalPointsEarned = pointsEarned;
	}
	
	@Override
	public void payAmount(double amt) {
		amt -= (amt * this.totalPointsEarned/100);
		double amtPayment = amt - (amt * DISCOUNT/100);
		System.out.println(" Amount to be paid by CreditCard is  "+amtPayment);
	}

}
