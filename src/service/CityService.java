package service;

import java.util.List;
import java.util.Set;

import model.City;
import repository.CityRepository;
import repository.Repository;

public class CityService extends AbstractService<City> {

	private Repository<City> repository;
	
	public CityService() {
		repository = new CityRepository();
	}
	
	@Override
	public Set<City> findAll() {
		return repository.findAll();
	}

	@Override
	public void insertAll(Set<City> entities) {
		repository.insertAll(entities);
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
