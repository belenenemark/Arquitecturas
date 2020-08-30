package interfaces;

import java.sql.SQLException;
import java.util.List;
import facturacion.FacturaProducto;

public interface DAOFactProd {
	
	public void crearTabla()throws SQLException;
	public void agregarFacturaProducto(FacturaProducto fp) throws SQLException;
	public void actualizarFacturaProducto(FacturaProducto fp1, FacturaProducto fp2)throws SQLException;
	public void borrarFacturaProducto(FacturaProducto fp)throws SQLException;
	public List<FacturaProducto> listarFacturasProductos()throws SQLException;

}
