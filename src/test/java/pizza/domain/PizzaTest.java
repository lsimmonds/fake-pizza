package pizza.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PizzaTest {

	@Test
	public void testGetToppings() {
		// given
		final Pizza pizza = new Pizza();
		// then
		assertEquals("New List not set", new ArrayList<Topping>(), pizza.getToppings());
	}

	@Test
	public void testHasCrust() {
		// given
		final Pizza pizza = new Pizza();
		// when
		pizza.setCrust(null);
		//then
		assertEquals("null Crust Returns true", false, pizza.hasCrust());
		
		// when
		pizza.setCrust(new Crust());
		//then
		assertEquals("set Crust Returns false", true, pizza.hasCrust());
	}

}
