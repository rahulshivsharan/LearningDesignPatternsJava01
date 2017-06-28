package org.designpatterns.chainofresponsibility.example01;

public class Dollar10Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;		
	}

	@Override
	public void dispense(Currency currency) {
		int num = 0;
		int remainder = 0;
		
		if(currency.getAmount() >= 10 ){
			
			// divide by 10 to get 
			// total number of 10$ bills can be
			// dispensed.
			num = currency.getAmount()/10;			
			System.out.println("Dispensing "+num+" number of $10 currency notes");
			
			// check the remainder of division
			// if remainder is not 0 than that 
			// amount of currency is still has to 
			// be dispensed from ATM, hence pass on that
			// remainder currency to next chain of dispenser
			remainder = currency.getAmount()%10;
			if(remainder != 0){
				this.chain.dispense(new Currency(remainder));
			}
		}else{ // if the currency is less than 10$
			   // then dispense the remaining amount
			   // in coins
			System.out.println("Dispensing amount of $ \""+currency.getAmount()+"\" in coins ");
		}		
	}// end of dispense

}
