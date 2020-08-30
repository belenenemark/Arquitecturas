package implementaciones;

import java.sql.SQLException;
import java.util.List;

import facturacion.Cliente;
import facturacion.Conexion;
import interfaces.DAOCliente;

public class DaoFacturaImpl extends Conexion implements DAOCliente{

	@Override
	public void crearTabla() throws SQLException {
		this.conectar();
		String table="CREATE TABLE factura (" + 
				"     idfactura INT NOT NULL AUTO_INCREMENT," + 
				"     idcliente VARCHAR(500) NOT NULL," +   
				"     PRIMARY KEY (idfactura)," + 
				"FOREIGN KEY (idcliente) REFERENCES Cliente(id)"+
				");";
	this.conn.prepareStatement(table).execute();
	this.conn.commit();	
	this.cerrarConexion();
		
	}

	@Override
	public void agregarCliente(Cliente c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCliente(Cliente c, Cliente c2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarCliente(Cliente c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listarClientes() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
