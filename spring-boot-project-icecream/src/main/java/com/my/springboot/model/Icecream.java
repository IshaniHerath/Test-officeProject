package com.my.springboot.model;

public class Icecream {

	private int id;
	private String cname;
	private String name;
	private int price;
	private int qty;
	private int total;

	public Icecream() {
	}

	public Icecream(int id, String cname, String name, int price, int qty, int total) {
		this.id = id;
		this.cname = cname;
		this.name = name;
		this.price = price;
		this.price = qty;
		this.price = total;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getCName() {
		return cname;
	}

	public void setCName(String cname) {
		this.cname = cname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
		
}