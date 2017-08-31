package com.ghostl.refactoring.pe;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String mName;
	private Vector mRentals = new Vector();
	
	public Customer(String name) {
		mName = name;
	}
	
	public void addRental(Rental arg){
		mRentals.addElement(arg);
	}

	public String getmName() {
		return mName;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = mRentals.elements();
		String result = "Rental Record for "+ getmName() + "\n";
		while(rentals.hasMoreElements()){
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			
			//determine amounts for each line
			switch (each.getmMovie().getmPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getmDaysRented() > 2){
					thisAmount += (each.getmDaysRented() - 2 ) * 1.5;
				}				
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getmDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if(each.getmDaysRented() > 3){
					thisAmount += (each.getmDaysRented() - 3) * 1.5;					
				}
				
			default:
				break;
			}
			
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if((each.getmMovie().getmPriceCode() == Movie.NEW_RELEASE) && each.getmDaysRented() > 1){
				frequentRenterPoints ++;
			} 
		}
		//show figures for this rental
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
		
	}
}
