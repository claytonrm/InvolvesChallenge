package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.City;
import repository.CityRepository;
import repository.Repository;

public class CityRepositoryTest {

	private Repository<City> repository;
	
	@Before
	public void setUp() throws Exception {
		repository = new CityRepository();
	}

	@Test
	public void shouldInsertAllCities() {
		final City city = createCity("Florianópolis", "SC");
		final City anotherCity = createCity("Gravatal", "SC");
		
		final Set<City> cities = new HashSet<>();
		cities.add(city);
		cities.add(anotherCity);
		
		repository.insertAll(cities);
		
		Assert.assertEquals(repository.findAll().size(), 2);
	}
	
	private City createCity(final String name, final String uf) {
		final City city = new City();
		city.setName(name);
		city.setUf(uf);
		return city;
	}

}
