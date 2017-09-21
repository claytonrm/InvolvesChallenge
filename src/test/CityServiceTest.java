package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.City;
import service.CityService;

public class CityServiceTest {

	@Test
	public void shouldCreateAListOfCities() {
		CityService.initialize();
		final List<City> cities = CityService.findAll();
		
		Assert.assertTrue(!cities.isEmpty());
	}
	
	@Test
	public void shouldFindACityCalledFlorianopolis() {
		CityService.initialize();
		final List<City> cities = CityService.findByName("Florianópolis");
		
		Assert.assertEquals("Florianópolis", cities.get(0).getName());
	}
	
}
