package interfaces;

import java.sql.SQLException;
import java.util.List;

import facturacion.Cliente;

public interface DAOCliente {
	
	public void crearTabla()throws SQLException;
	public void agregarCliente(Cliente c) throws SQLException;
	public void actualizarCliente(Cliente c, Cliente c2)throws SQLException;
	public void borrarCliente(Cliente c)throws SQLException;
	public List<Cliente> listarClientes()throws SQLException;

}
