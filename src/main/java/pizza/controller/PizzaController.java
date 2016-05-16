package pizza.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pizza.domain.Crust;
import pizza.domain.Pizza;
import pizza.domain.Sauce;
import pizza.domain.Topping;
import pizza.service.CrustService;
import pizza.service.PizzaService;
import pizza.service.SauceService;
import pizza.service.ToppingService;

@Controller
@ComponentScan(basePackages = { "pizza.service" })
public class PizzaController {
	@Autowired
	private CrustService crustService;

	@Autowired
	private SauceService sauceService;

	@Autowired
	private ToppingService toppingService;

	@Autowired
	private PizzaService pizzaService;

	private List<Crust> crustList;
	private List<Sauce> sauceList;
	private List<Topping> toppingList;
	private Pizza pizza = new Pizza();
	private List<Pizza> pizzaList;
	private BigDecimal totalPrice;
	private boolean onConfirm = false;

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public void pizzaAdd(Model model) {
		crustList = crustService.findAll();
		sauceList = sauceService.findAll();
		toppingList = toppingService.findAll();
		pizzaList = pizzaService.findAll();
		totalPrice = pizzaService.getPrice();
		model.addAttribute("crustList", crustList);
		model.addAttribute("sauceList", sauceList);
		model.addAttribute("toppingList", toppingList);
		model.addAttribute("pizza", this.pizza);
		model.addAttribute("pizzaList", pizzaList);
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("onConfirm",onConfirm);
	}

	@RequestMapping(value = "/home", params = { "pizzaConfirm" }, method = RequestMethod.POST)
	public String pizzaConfirm(final HttpServletRequest req) {
		final boolean noSauce = Boolean.parseBoolean(req.getParameter("pizzaConfirm"));
		if (noSauce) {
			pizzaService.add(this.pizza);
			this.pizza = new Pizza();
		}
		else {
			onConfirm = false;
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = { "pizzaAddSubmit" }, method = RequestMethod.POST)
	public String pizzaAddSubmit() {
		if (this.pizza.getSauce() == null) {
			onConfirm = true;
			return "redirect:/home";
		}
		pizzaService.add(this.pizza);
		this.pizza = new Pizza();
		onConfirm = false;
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = { "pickSauce" })
	public String pickSauce(final HttpServletRequest req) {
		onConfirm = false;
		if (req.getParameter("sauceIndex") != null) {
			final Integer sauceIndex = Integer.valueOf(req.getParameter("sauceIndex"));
			if(this.pizza.getSauce() != null) {
				this.pizza.setPrice(this.pizza.getPrice().subtract(this.pizza.getSauce().getPrice()));
			}
			this.pizza.setSauce(sauceList.get(sauceIndex));
			this.pizza.setSauceIndex(sauceIndex);
			this.pizza.setPrice(this.pizza.getPrice().add(this.pizza.getSauce().getPrice()));
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = { "pickCrust" })
	public String pickCrust(final HttpServletRequest req) {
		if(this.pizza.getPrice()==null) {
			this.pizza.setPrice(BigDecimal.ZERO);
		}
		if (req.getParameter("crustIndex") != null) {
			final Integer crustIndex = Integer.valueOf(req.getParameter("crustIndex"));
			if(this.pizza.getCrust() != null) {
				this.pizza.setPrice(this.pizza.getPrice().subtract(this.pizza.getCrust().getPrice()));
			}
			this.pizza.setCrust(crustList.get(crustIndex));
			this.pizza.setCrustIndex(crustIndex);
			this.pizza.setPrice(this.pizza.getPrice().add(this.pizza.getCrust().getPrice()));
			onConfirm = false;
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = { "addTopping" })
	public String addTopping(final HttpServletRequest req) {
		final Integer toppingIndex = Integer.valueOf(req.getParameter("toppingIndex"));
		pizza.getToppings().add(toppingList.get(toppingIndex));
		this.pizza.setPrice(this.pizza.getPrice().add(toppingList.get(toppingIndex).getPrice()));
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", params = { "removeTopping" })
	public String removeTopping(final HttpServletRequest req) {
		final Integer toppingIndex = Integer.valueOf(req.getParameter("removeTopping"));
		this.pizza.getToppings().remove(toppingIndex.intValue());
		this.pizza.setPrice(this.pizza.getPrice().subtract(toppingList.get(toppingIndex).getPrice()));
		return "redirect:/home";
	}
}
