package repository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractRepository<T> implements Repository<T>{
	
	private Set<T> entities;

	@Override
	public void insertAll(final Set<T> entities) {
		this.entities = new HashSet<>();
		this.entities.addAll(entities);
	}
	
	@Override
	public Set<T> findAll() {
		return this.entities;
	}
	
}
