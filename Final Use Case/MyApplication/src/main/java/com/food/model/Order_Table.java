package com.food.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order_Table {
	@Id
	private int order_id;
	private String order_name;
	private int user_id;
	private String dish_name;
	private String ingredients;
	private int quantity;
	private int price;
	private String date_of_order;
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate_of_order() {
		return date_of_order;
	}
	public void setDate_of_order(String date_of_order) {
		this.date_of_order = date_of_order;
	}
	@Override
	public String toString() {
		return "Order_Table [order_id=" + order_id + ", order_name=" + order_name + ", user_id=" + user_id
				+ ", dish_name=" + dish_name + ", ingredients=" + ingredients + ", quantity=" + quantity + ", price="
				+ price + ", date_of_order=" + date_of_order + "]";
	}
	
}
