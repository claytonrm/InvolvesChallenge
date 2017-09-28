package br.com.involves.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.involves.model.City;
import br.com.involves.repository.CityInMemoryRepository;
import br.com.involves.repository.Repository;
import br.com.involves.util.PropertyUtil;

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
	public Set<City> findAllDistinctBy(final String property) {
		final Set<City> allCities = findAll();
		final Set<City> allDistinctedCities = new HashSet<>();
		for (City city : allCities) {
			final City c = new City();
			PropertyUtil.setValueToAttribute(c, PropertyUtil.getAttributeValue(city, property), property);
			allDistinctedCities.add(c);
		}
		
		return allDistinctedCities;
	}
	
	@Override
	public List<City> filterBy(final String property, final Object value) {
		final List<City> allCities = new ArrayList<>(findAll());
		
		return allCities.stream()
			     .filter(item -> PropertyUtil.isEqual(PropertyUtil.getAttributeValue(item, property), value))
			     .collect(Collectors.toList());
	}

}
