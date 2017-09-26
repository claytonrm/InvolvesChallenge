package repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.City;
import repository.CityInMemoryRepository;
import repository.Repository;

public class CityInMemoryRepositoryTest {

	private Repository<City> repository;

	@Before
	public void setUp() throws Exception {
		repository = new CityInMemoryRepository();
	}
	
	@Test
	public void shouldInsertAllCities() {
		final City city = createCity(1L, "Florianópolis", "SC");
		final City anotherCity = createCity(2L, "Gravatal", "SC");
		
		final Set<City> cities = new HashSet<>();
		cities.add(city);
		cities.add(anotherCity);
		
		repository.insertAll(cities);
		
		Assert.assertEquals(repository.findAll().size(), 2);
	}
	
	private City createCity(final Long ibgeId, final String name, final String uf) {
		final City city = new City();
		city.setIbgeId(ibgeId);
		city.setName(name);
		city.setUf(uf);
		return city;
	}

}
