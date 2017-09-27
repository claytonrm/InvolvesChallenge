package service;

import java.util.List;
import java.util.Set;

public interface Service<T> {

	void insertAll(final Set<T> entities);

	Set<T> findAll();
	
	Set<T> findAllDistinctBy(final String property);

	List<T> filterBy(final String property, final Object value);

}
