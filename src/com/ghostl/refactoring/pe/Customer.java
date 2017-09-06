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
		int frequentRenterPoints = 0;
		Enumeration rentals = mRentals.elements();
		String result = "Rental Record for "+ getmName() + "\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			//show figures for this rental
			result += "\t" + each.getmMovie().getmTitle() + "\t" +
					String.valueOf(each.getCharge() + "\n");
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(geTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
		
	}
	
	
	
	private double geTotalCharge() {
		double result = 0;
		Enumeration rentals = mRentals.elements();
		while (rentals.hasMoreElements()){
			Rental each =(Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	//TODO Cambio el nombre de algunas variables de manera mas descriptiva
	private double amountFor(Rental aRental){//TODO 1 Change name Variable each to aRental
		
		return aRental.getCharge();
		//Comment to change method of place to Rental class
		/*double result = 0; //TODO 2 Change name variable thisAmount to result
		switch (aRental.getmMovie().getmPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(aRental.getmDaysRented() > 2){
				result += (aRental.getmDaysRented() - 2 ) * 1.5;
			}				
			break;
		case Movie.NEW_RELEASE:
			result += aRental.getmDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(aRental.getmDaysRented() > 3){
				result += (aRental.getmDaysRented() - 3) * 1.5;					
			}
			
		default:
			break;
		}
		return result;*/
	}
}
