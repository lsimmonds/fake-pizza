package pizza.domain;

import java.math.BigDecimal;

public class Crust {
	private String name;
	private BigDecimal price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Crust findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
