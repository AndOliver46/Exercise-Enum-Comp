package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	List<OrderItem> items = new ArrayList<>();
	Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Double total() {
		double total = 0;

		for(OrderItem x : items) {
			total += x.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nOrder sumary:\n");
		builder.append("Order moment: ");
		builder.append(moment + "\n");
		builder.append("Order status: ");
		builder.append(status + "\n");
		
		builder.append(client.toString());
		
		builder.append("Order items: \n");
		for(OrderItem x : items) {
			builder.append(x.toString() + "\n");
		}
		builder.append("Total price: $");
		builder.append(String.format("%.2f", total()) + "\n");
		return builder.toString();
	}
}
