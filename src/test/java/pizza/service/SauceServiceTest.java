package pizza.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pizza.domain.Sauce;

public class SauceServiceTest {

	@Test
	public void testSauceService() {
		//given
		SauceService sauceService = new SauceService();
		List<Sauce> sauceList = sauceService.findAll();
		//then
		assertEquals("There elements are not set", 3, sauceList.size());
		//then
		assertEquals("First Element is not Thin White","Red",sauceList.get(0).getName());
		assertEquals("Second Element is not Thick Wheat","White",sauceList.get(1).getName());
		assertEquals("Third Element is not Thick White","Salsa",sauceList.get(2).getName());
	}

}
