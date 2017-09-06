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
		Enumeration rentals = mRentals.elements();
		String result = "Rental Record for "+ getmName() + "\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			//show figures for this rental
			result += "\t" + each.getmMovie().getmTitle() + "\t" +
					String.valueOf(each.getCharge() + "\n");
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		
		return result;
		
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = mRentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result =+ each.getFrequentRenterPoints();
		}
		return result;
	}

	private double getTotalCharge() {
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
	
	public String htmlStatement(){
		Enumeration rentals = mRentals.elements();
		String result = "<H1> Rentals for <EM> " + getmName() + "</EM> </H1> <P>\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			
			//Show figures for each rental
			result += each.getmMovie().getmTitle() + ": "+ String.valueOf(each.getCharge()) + "<BR>\n";
			
		}
		//add footer lines
		result += "<P> You owe <EM>" + String.valueOf(getTotalCharge())+ "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())+ "</EM> frequent renter points <P>";
		return result;
	}
}
