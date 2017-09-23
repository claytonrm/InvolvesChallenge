package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.City;
import repository.CityInMemoryRepository;
import repository.Repository;
import util.Util;

public class CityService implements Service<City> {

	private Repository<City> repository;
	
	public CityService() {
		repository = new CityInMemoryRepository();
	}
	
	@Override
	public void insertAll(final Set<City> entities) {
		repository.insertAll(entities);
	}
	
	@Override
	public Set<City> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Set<City> findAllDistinctBy(String[] columns) {
		return null;
	}
	
	@Override
	public long countAll() {
		return findAll().size();
	}

	@Override
	public long countDistinctBy(final String property) {
		return 6;
	}
	
	@Override
	public List<City> filterBy(final String property, final Object value) {
		final List<City> allCities = new ArrayList<>(findAll());
		
		return allCities.stream()
			     .filter(item -> Util.isEqual(Util.getAttributeValue(item, property), value))
			     .collect(Collectors.toList());
	}

}
