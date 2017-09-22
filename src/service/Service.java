package service;

import java.util.Set;

public interface Service<T> {

	void insertAll(final Set<T> entities);

	Set<T> findAll();

}
