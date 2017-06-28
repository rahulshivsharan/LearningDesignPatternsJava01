package org.designpatterns.chainofresponsibility.example01;

public class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		chain = nextChain;		
	}

	@Override
	public void dispense(Currency currency) {
		int num = 0;
		int remainder = 0;
		
		if(currency.getAmount() >= 50 ){
			
			// divide by 50 to get 
			// total number of 50$ bills can be
			// dispensed.
			num = currency.getAmount()/50;			
			System.out.println("Dispensing \""+num+"\" number of $50 currency notes");
			
			// check the remainder of division
			// if remainder is not 0 than that 
			// amount of currency is still has to 
			// be dispensed from ATM, hence pass on that
			// remainder currency to next chain of dispenser
			remainder = currency.getAmount()%50;
			if(remainder != 0){
				this.chain.dispense(new Currency(remainder));
			}
		}else{ // if the currency is less than 50$
			   // pass on to the next chain of dispenser
			   // which will be able to dispense out the 
			   // currency
			this.chain.dispense(currency); 
		}		
		
	}// end of dispense
	
}
