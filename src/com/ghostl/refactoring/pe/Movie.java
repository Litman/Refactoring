package com.ghostl.refactoring.pe;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String mTitle;
	private int mPriceCode;
	
	public Movie(String title, int priceCode) {
		mTitle = title;
		mPriceCode = priceCode;
	}

	public int getmPriceCode() {
		return mPriceCode;
	}

	public void setmPriceCode(int mPriceCode) {
		this.mPriceCode = mPriceCode;
	}
	
	public String getmTitle() {
		return mTitle;
	}
	
	//Move from object Rental, because in here use other object in the method switch
	double getCharge(int daysRented){
		double result = 0; 
		switch (getmPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(daysRented > 2){
				result += (daysRented - 2 ) * 1.5;
			}				
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(daysRented > 3){
				result += (daysRented - 3) * 1.5;					
			}
			
		default:
			break;
		}
		return result;
	}
	
	int getFrequentRenterPoints(int daysRented){
		if((getmPriceCode() == Movie.NEW_RELEASE) && daysRented >1){
			return 2;
		}else
		{
			return 1;
		}
		
	}
	
}
