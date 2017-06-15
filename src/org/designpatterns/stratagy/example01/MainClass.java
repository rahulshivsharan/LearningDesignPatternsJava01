package org.designpatterns.stratagy.example01;

public class MainClass {
	public static void main(String [] args){
		Customer customer = null;
		PaymentStratagy[] stratagies = null; 
		try{
			stratagies = new PaymentStratagy[] { 
					new PayTmWalletPayment(1200), 
					new CreditcardPayment(120), 
					new DebitcardPayment()
			};
			
			
			customer = new Customer(stratagies[0]); // pay my PayTM			
			customer.addAmount(200); // selected goods af amount 200
			customer.payment();
			
			customer.resetAmount();
			customer.addAmount(2300); // selected goods af amount 2300 
			customer.addAmount(300); // selected goods af amount 300 
			customer.setPaymentStratagy(stratagies[1]);//Creditcard payment
			customer.payment();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
