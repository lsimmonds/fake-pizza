package pizza.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pizza.domain.Topping;

public class ToppingServiceTest {

	@Test
	public void testToppingService() {
		//given
		ToppingService toppingService = new ToppingService();
		List<Topping> toppingList = toppingService.findAll();
		//then
		assertEquals("There elements are not set", 4, toppingList.size());
		//then
		assertEquals("First Element is not Pepperoni","Pepperoni",toppingList.get(0).getName());
		assertEquals("Second Element is not Pepperoni","Onions",toppingList.get(1).getName());
		assertEquals("Third Element is not Thumbtacks","Thumbtacks",toppingList.get(2).getName());
		assertEquals("Third Element is not Caviar","Caviar",toppingList.get(3).getName());
	}

}
