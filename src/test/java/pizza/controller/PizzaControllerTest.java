package pizza.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pizza.domain.Pizza;
import pizza.domain.Topping;
import pizza.service.CrustService;
import pizza.service.PizzaService;
import pizza.service.SauceService;
import pizza.service.ToppingService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:test-servlet-context.xml")
public class PizzaControllerTest {

	private MockMvc mockMvc;

	@Bean
	public CrustService crustService() {
		return Mockito.mock(CrustService.class);
	}

	@Bean
	public SauceService sauceService() {
		return Mockito.mock(SauceService.class);
	}

	@Mock
	private CrustService crustService;

	@Mock
	private SauceService sauceService;
	
	@Mock
	private PizzaService pizzaService;
	
	@Mock
	private Pizza pizza;

	@Mock
	private ToppingService toppingService;
	
	@InjectMocks
	private PizzaController pizzaController;

	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/Pizza/src/main/resources/templates");
		viewResolver.setSuffix(".html");
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(pizzaController).setViewResolvers(viewResolver).build();
		
		List<Topping> toppingList = new LinkedList<Topping>();
		Topping topping = new Topping();
		topping.setName("Pepperoni");
		topping.setPrice(new BigDecimal(.50));
		toppingList.add(topping);
		topping.setName("Onions");
		topping.setPrice(new BigDecimal(.50));
		toppingList.add(topping);
		topping.setName("Thumbtacks");
		topping.setPrice(new BigDecimal(.50));
		toppingList.add(topping);
		topping.setName("Caviar");
		topping.setPrice(new BigDecimal(6));
		toppingList.add(topping);
		Mockito.when(this.toppingService.findAll()).thenReturn(toppingList);
		toppingList = new LinkedList<Topping>();
		topping.setName("Pepperoni");
		topping.setPrice(new BigDecimal(.50));
		toppingList.add(topping);
		topping.setName("Caviar");
		topping.setPrice(new BigDecimal(6));
		toppingList.add(topping);
		Mockito.when(this.pizza.getToppings()).thenReturn(toppingList);
		Mockito.when(this.pizza.getPrice()).thenReturn(BigDecimal.TEN);
	}

	@Test
	public void testPizzaAdd() throws Exception {
		this.mockMvc.perform(get("/home")).andExpect(status().isOk());
	}

	@Test
	public void testPizzaConfirm() throws Exception {
		this.mockMvc.perform(post("/home").param("pizzaConfirm", "")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testPizzaAddSubmit() throws Exception {
		this.mockMvc.perform(post("/home").param("pizzaAddSubmit", "")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testPickSauce() throws Exception {
		this.mockMvc.perform(post("/home").param("pickSauce", "")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testPickCrust() throws Exception {
		this.mockMvc.perform(post("/home").param("pickCrust", "")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testAddTopping() throws Exception {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("addTopping", "");
		parameters.add("toppingIndex", "0");
		this.mockMvc.perform(get("/home")); //Does some values setup
		this.mockMvc.perform(post("/home").params(parameters)).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testRemoveTopping() throws Exception {
		this.mockMvc.perform(get("/home")); //Does some values setup
		this.mockMvc.perform(post("/home").param("removeTopping", "0")).andExpect(status().is3xxRedirection());
	}

}
