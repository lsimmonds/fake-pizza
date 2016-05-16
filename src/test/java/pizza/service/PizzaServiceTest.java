package pizza.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import pizza.domain.Pizza;

public class PizzaServiceTest {

	@Test
	public void testGetPrice() {
		// given
		PizzaService pizzaService = new PizzaService();
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();
		Pizza pizza4 = new Pizza();
		pizza1.setPrice(new BigDecimal("12.00"));
		pizza2.setPrice(new BigDecimal("11.00"));
		pizza3.setPrice(BigDecimal.TEN);
		pizza4.setPrice(new BigDecimal("9.00"));
		pizzaService.add(pizza1);
		pizzaService.add(pizza2);
		pizzaService.add(pizza3);
		pizzaService.add(pizza4);
		BigDecimal pizzaPriceSum = pizza1.getPrice()
				.add(pizza2.getPrice().add(pizza3.getPrice().add(pizza4.getPrice())));
		// then
		assertEquals("Price is not sum of pizza prices", pizzaPriceSum, pizzaService.getPrice());
	}

}
