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
		return mMovie.getCharge(mDaysRented);
	}
	
	int getFrequentRenterPoints(){
		return mMovie.getFrequentRenterPoints(mDaysRented);
	}
	
}
