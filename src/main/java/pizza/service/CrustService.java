package pizza.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pizza.domain.Crust;

@Service
public class CrustService {
	private List<Crust> crustList = new LinkedList<Crust>();

	CrustService() {
		Crust Crust1 = new Crust();
		Crust1.setName("Thin White");
		Crust1.setPrice(new BigDecimal(9));
		crustList.add(Crust1);
 
		Crust Crust2 = new Crust();
		Crust2.setName("Thick Wheat");
		Crust2.setPrice(new BigDecimal(9));
		crustList.add(Crust2);
 
		Crust Crust3 = new Crust();
		Crust3.setName("Thick White");
		Crust3.setPrice(new BigDecimal(9));
		crustList.add(Crust3);
	}

	public List<Crust> findAll() {
		return crustList;
	}
	
	public Crust findByIndex(final Integer id) {
		return crustList.get(id);
	}

}
