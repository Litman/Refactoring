package com.ghostl.refactoring.pe;

public class Rental {

	private Movie mMovie;
	private int mDaysRented;
	
	public Rental(Movie movie, int daysRented) {
		mMovie = movie;
		mDaysRented = daysRented;
	}
	
	public int getmDaysRented() {
		return mDaysRented;
	}
	
	public Movie getmMovie() {
		return mMovie;
	}
	

	double getCharge(){//TODO Move method amountFor to a correct object
		double result = 0; 
		switch (getmMovie().getmPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(getmDaysRented() > 2){
				result += (getmDaysRented() - 2 ) * 1.5;
			}				
			break;
		case Movie.NEW_RELEASE:
			result += getmDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(getmDaysRented() > 3){
				result += (getmDaysRented() - 3) * 1.5;					
			}
			
		default:
			break;
		}
		return result;
	}
	
	int getFrequentRenterPoints(){
		if((getmMovie().getmPriceCode() == Movie.NEW_RELEASE) && getmDaysRented() > 1){
			return 2;
		} 
		else{
			return 1;
		}
	}
	
}
