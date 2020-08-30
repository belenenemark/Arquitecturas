package interfaces;

import java.sql.SQLException;
import java.util.List;

import facturacion.Cliente;
import facturacion.FacturaProducto;

public interface DAOFactProd {
	
	public void crearTabla()throws SQLException;
	public void agregarCliente(FacturaProducto fp) throws SQLException;
	public void actualizarCliente(FacturaProducto fp1, FacturaProducto fp2)throws SQLException;
	public void borrarCliente(FacturaProducto fp)throws SQLException;
	public List<Cliente> listarClientes()throws SQLException;

}
