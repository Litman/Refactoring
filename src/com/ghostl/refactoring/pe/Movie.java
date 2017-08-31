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
	
	
}
