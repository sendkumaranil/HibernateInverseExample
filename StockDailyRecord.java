package com.hibernate.inverseexample.model;

import java.util.Date;

public class StockDailyRecord {
	private int id;
	private String priceOpen;
	private String priceClose;
	private String priceChange;
	private int volume;
	private Date date;
	private Stock stock;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriceOpen() {
		return priceOpen;
	}
	public void setPriceOpen(String priceOpen) {
		this.priceOpen = priceOpen;
	}
	public String getPriceClose() {
		return priceClose;
	}
	public void setPriceClose(String priceClose) {
		this.priceClose = priceClose;
	}
	public String getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(String priceChange) {
		this.priceChange = priceChange;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	

}
