package interfaces;

import java.sql.SQLException;
import java.util.List;

import facturacion.Cliente;
import facturacion.Producto;

public interface DAOProducto {
	
	public void crearTabla()throws SQLException;
	public void agregarCliente(Producto pr) throws SQLException;
	public void actualizarCliente(Producto pr, Producto pr2)throws SQLException;
	public void borrarCliente(Producto pr)throws SQLException;
	public List<Cliente> listarClientes()throws SQLException;

}
