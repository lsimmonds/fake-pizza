package pizza.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pizza.domain.Topping;

@Service
public class ToppingService {
	private List<Topping> toppingList = new LinkedList<Topping>();

	ToppingService() {
		Topping Topping1 = new Topping();
		Topping1.setName("Pepperoni");
		Topping1.setPrice(new BigDecimal(.50));
		toppingList.add(Topping1);

		Topping Topping2 = new Topping();
		Topping2.setName("Onions");
		Topping2.setPrice(new BigDecimal(.50));
		toppingList.add(Topping2);

		Topping Topping3 = new Topping();
		Topping3.setName("Thumbtacks");
		Topping3.setPrice(new BigDecimal(.50));
		toppingList.add(Topping3);
		
		Topping Topping4 = new Topping();
		Topping4.setName("Caviar");
		Topping4.setPrice(new BigDecimal(6));
		toppingList.add(Topping4);
	}

	public List<Topping> findAll() {
		return toppingList;
	}
}
