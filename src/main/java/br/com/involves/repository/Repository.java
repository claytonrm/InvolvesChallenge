package br.com.involves.repository;

import java.util.Set;

public interface Repository<T> {

	void insertAll(final Set<T> entities);
	
	Set<T> findAll();

}
