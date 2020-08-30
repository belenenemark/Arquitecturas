package interfaces;

import java.sql.SQLException;
import java.util.List;
import facturacion.Producto;

public interface DAOProducto {
	
	public void crearTabla()throws SQLException;
	public void agregarProducto(Producto pr) throws SQLException;
	public void actualizarProducto(Producto pr, Producto pr2)throws SQLException;
	public void borrarProducto(Producto pr)throws SQLException;
	public List<Producto> listarProductos()throws SQLException;
	public void cargarDesdeCsv()throws SQLException;

}
