package repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class InMemoryRepository<T> implements Repository<T>{
	
	private Set<T> entities = new HashSet<>();

	@Override
	public void insertAll(final Set<T> entities) {
		this.entities.addAll(entities);
	}
	
	@Override
	public Set<T> findAll() {
		return Collections.unmodifiableSet(entities);
	}
	
}
