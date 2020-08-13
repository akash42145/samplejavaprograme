package com.sample.map.partition;

public class SecurityData {
	private String currencyCode;
	private int instrumentType;
	
	
	public SecurityData(String currencyCode, int instrumentType) {
		super();
		this.currencyCode = currencyCode;
		this.instrumentType = instrumentType;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public int getInstrumentType() {
		return instrumentType;
	}
	public void setInstrumentType(int instrumentType) {
		this.instrumentType = instrumentType;
	}
	
	

}
