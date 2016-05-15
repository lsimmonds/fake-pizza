package pizza.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private BigDecimal price=BigDecimal.ZERO;
	private Crust crust;
	private Integer crustIndex;
	private Sauce sauce;
	private Integer sauceIndex;
	private List<Topping> toppings;
	private Integer toppingIndex;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public List<Topping> getToppings() {
		if (toppings == null) {
			setToppings(new ArrayList<Topping>());
		}
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

	public Integer getCrustIndex() {
		return crustIndex;
	}

	public void setCrustIndex(Integer crustIndex) {
		this.crustIndex = crustIndex;
	}

	public Integer getSauceIndex() {
		return sauceIndex;
	}

	public void setSauceIndex(Integer sauceIndex) {
		this.sauceIndex = sauceIndex;
	}

	public Integer getToppingIndex() {
		return toppingIndex;
	}

	public void setToppingIndex(Integer toppingIndex) {
		this.toppingIndex = toppingIndex;
	}
	
	public boolean hasCrust() {
		return getCrust() != null;
	}
}
