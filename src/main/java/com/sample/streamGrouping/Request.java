package com.sample.streamGrouping;

import java.time.LocalDate;

public class Request {
	
	private String currency;
	private LocalDate date;
	private Double rate;	
	
	public Request(String currency, LocalDate date, Double rate) {
		super();
		this.currency = currency;
		this.date = date;
		this.rate = rate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Request [currency=" + currency + ", date=" + date + ", rate=" + rate + "]";
	}
	
}
