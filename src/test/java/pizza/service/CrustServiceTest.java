package pizza.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pizza.domain.Crust;

public class CrustServiceTest {

	@Test
	public void testCrustService() {
		//given
		CrustService crustService = new CrustService();
		List<Crust> crustList = crustService.findAll();
		//then
		assertEquals("There elements are not set", 3, crustList.size());
		//then
		assertEquals("First Element is not Thin White","Thin White",crustList.get(0).getName());
		assertEquals("Second Element is not Thick Wheat","Thick Wheat",crustList.get(1).getName());
		assertEquals("Third Element is not Thick White","Thick White",crustList.get(2).getName());
	}

}
