package implementaciones;

import java.sql.SQLException;
import java.util.List;

import facturacion.Conexion;
import facturacion.FacturaProducto;
import interfaces.DAOFactProd;

public class DAOFactProdImpl extends Conexion implements DAOFactProd {

	@Override
	public void crearTabla() throws SQLException {
		this.conectar();
		String table="CREATE TABLE facturaproducto ("+
				"				    idfactura INT NOT NULL , "+
				"			    idproducto int NOT NULL," + 
				"			    cantidad INT," + 
				"				  PRIMARY KEY (idfactura,idproducto)," + 
				"				FOREIGN KEY (idfactura) REFERENCES factura(idfactura)," + 
				"				FOREIGN KEY (idproducto) REFERENCES producto(idproducto)" + 
				"				);";
	this.conn.prepareStatement(table).execute();
	this.conn.commit();	
	this.cerrarConexion();
		
	}

	@Override
	public void agregarFacturaProducto(FacturaProducto fp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarFacturaProducto(FacturaProducto fp1, FacturaProducto fp2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarFacturaProducto(FacturaProducto fp) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FacturaProducto> listarFacturasProductos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
