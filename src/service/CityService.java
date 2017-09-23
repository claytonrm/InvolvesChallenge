package service;

import java.util.List;
import java.util.Set;

import model.City;
import repository.CityInMemoryRepository;
import repository.Repository;

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

	public static List<City> findBy(final String property, final String value) {
//		Method[] methods = City.class.getDeclaredMethods();
//        
//		for (Method method : methods) {
//            Annotation[] annotations = method.getDeclaredAnnotations();
//            for (Annotation annotation : annotations) {
//                if(annotation instanceof CSVProperty){
//                    method.invoke(City.class, );
//                }
//            }
//        }
//		final List<City> result = cities.stream()
//			     .filter(item -> item.getName().equals(value))
//			     .collect(Collectors.toList());
		return null;
	}
}
