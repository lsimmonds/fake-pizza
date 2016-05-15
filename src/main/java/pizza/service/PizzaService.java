package pizza.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import pizza.domain.Pizza;

@Service
public class PizzaService {
	private List<Pizza> pizzaList = new LinkedList<Pizza>();
	private String customerName;
	private String customerPhoneNumber;
	private BigDecimal price;

	PizzaService() {
		
	}
	
	public void add(Pizza pizza) {
		pizzaList.add(pizza);
	}
	
	public List<Pizza> findAll() {
		return pizzaList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public BigDecimal getPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (ListIterator<Pizza> iter = pizzaList.listIterator(); iter.hasNext();) {
			Pizza pizza = iter.next();
			totalPrice=totalPrice.add(pizza.getPrice());
		}
		return totalPrice;
	}
}
