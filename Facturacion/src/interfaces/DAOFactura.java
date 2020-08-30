package interfaces;

import java.sql.SQLException;
import java.util.List;

import facturacion.Cliente;
import facturacion.Factura;

public interface DAOFactura {
	
	public void crearTabla()throws SQLException;
	public void agregarCliente(Factura  p) throws SQLException;
	public void actualizarCliente(Factura p, Factura p2)throws SQLException;
	public void borrarCliente(Factura p)throws SQLException;
	public List<Factura> listarClientes()throws SQLException;

}
