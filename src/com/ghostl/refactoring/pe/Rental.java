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
	

}
