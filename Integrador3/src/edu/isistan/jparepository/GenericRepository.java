package edu.isistan.jparepository;

import java.util.List;

public interface GenericRepository<T,K> {

	T insert(T a);

	void update (T a);

	void delete (K id);

	List<T> getALL();

	T getId(K id);

}
