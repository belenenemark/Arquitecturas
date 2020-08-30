package implementaciones;

import java.sql.SQLException;
import java.util.List;

import facturacion.Factura;
import facturacion.Conexion;
import interfaces.DAOFactura;

public class DaoFacturaImpl extends Conexion implements DAOFactura{

	@Override
	public void crearTabla() throws SQLException {
		this.conectar();
		String table="CREATE TABLE factura (" + 
				"     idfactura INT NOT NULL ," + 
				"     idcliente int NOT NULL," +   
				"     PRIMARY KEY (idfactura)," + 
				"FOREIGN KEY (idcliente) REFERENCES Cliente(id)"+
				");";
	this.conn.prepareStatement(table).execute();
	this.conn.commit();	
	this.cerrarConexion();
		
	}

	@Override
	public void agregarFactura(Factura p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarFactura(Factura p, Factura p2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarFactura(Factura p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> listarFacturas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
