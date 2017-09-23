package test;

import java.util.HashSet;
import java.util.List;
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
	public void shouldInsertAllCities() {
		final Set<City> cities = createAnyCities();
		
		service.insertAll(cities);
		
		Assert.assertTrue(!cities.isEmpty());
		Assert.assertEquals(cities.size(), 4);
	}
	
	@Test
	public void shouldFilterCityByStringPropertyValue() {
		final Set<City> cities = createAnyCities();
		service.insertAll(cities);
		
		final List<City> foundCities = service.filterBy("name", "Palmas");
		
		final City cityPalmasTo = createCity(1L, "Palmas", "TO");
		final City cityPalmasPr = createCity(2L, "Palmas", "PR");
		final City cityGravatal = createCity(3L, "Gravatal", "SC");
		final City cityFloripa = createCity(4L, "Florianópolis", "SC");
		
		Assert.assertEquals(2, foundCities.size());
		Assert.assertTrue(foundCities.contains(cityPalmasPr));
		Assert.assertTrue(foundCities.contains(cityPalmasTo));
		Assert.assertTrue(!foundCities.contains(cityGravatal));
		Assert.assertTrue(!foundCities.contains(cityFloripa));
	}

	@Test
	public void shouldFilterCityByLongPropertyValue() {
		final Set<City> cities = createAnyCities();
		service.insertAll(cities);
		
		final List<City> foundCities = service.filterBy("ibge_id", 3L);
		
		final City cityPalmasTo = createCity(1L, "Palmas", "TO");
		final City cityPalmasPr = createCity(2L, "Palmas", "PR");
		final City cityGravatal = createCity(3L, "Gravatal", "SC");
		final City cityFloripa = createCity(4L, "Florianópolis", "SC");
		
		Assert.assertEquals(1, foundCities.size());
		Assert.assertTrue(!foundCities.contains(cityPalmasPr));
		Assert.assertTrue(!foundCities.contains(cityPalmasTo));
		Assert.assertTrue(foundCities.contains(cityGravatal));
		Assert.assertTrue(!foundCities.contains(cityFloripa));
	}


	private Set<City> createAnyCities() {
		final Set<City> cities = new HashSet<>();
		cities.add(createCity(1L, "Palmas", "TO"));
		cities.add(createCity(2L, "Palmas", "PR"));
		cities.add(createCity(3L, "Gravatal", "SC"));
		cities.add(createCity(4L, "Florianópolis", "SC"));
		return cities;
	}
	
	private City createCity(final Long ibgeId, final String name, final String uf) {
		final City city = new City();
		city.setIbgeId(ibgeId);
		city.setName(name);
		city.setUf(uf);
		return city;
	}
	
}
