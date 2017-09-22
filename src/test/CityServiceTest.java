package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.City;
import service.CityService;
import service.Service;

public class CityServiceTest {

	private Service<City> service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new CityService();
	}
	
	@Test
	public void shouldCreateASetOfCities() {
		final Set<City> cities = new HashSet<>();
		final City city = new City();
		city.setName("Florianópolis");
		cities.add(city);
		
		service.insertAll(cities);
		
		Assert.assertTrue(!cities.isEmpty());
		Assert.assertEquals(cities.size(), 1);
	}
}
