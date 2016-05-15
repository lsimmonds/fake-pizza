package pizza.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pizza.domain.Sauce;

@Service
public class SauceService {
	private List<Sauce> sauceList = new LinkedList<Sauce>();

	SauceService() {
		Sauce Sauce1 = new Sauce();
		Sauce1.setName("Red");
		Sauce1.setPrice(new BigDecimal(1));
		sauceList.add(Sauce1);

		Sauce Sauce2 = new Sauce();
		Sauce2.setName("White");
		Sauce2.setPrice(new BigDecimal(1));
		sauceList.add(Sauce2);

		Sauce Sauce3 = new Sauce();
		Sauce3.setName("Salsa");
		Sauce3.setPrice(new BigDecimal(1.50));
		sauceList.add(Sauce3);
	}

	public List<Sauce> findAll() {
		return sauceList;
	}
}
