package arqui.dao;

import java.util.List;

public interface DAO<T,K> {

	void crearTabla();
	
	void insertar(T a);

	void modificar (T a, T b);
	
	void eliminar (T a);
	
	List<T> obtenerTodos();
	
	T obtener(K id);
	
}
