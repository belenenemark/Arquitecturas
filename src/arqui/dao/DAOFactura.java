package arqui.dao;

import arqui.modelo.Factura;

public interface DAOFactura extends DAO<Factura, Integer>{
	
	public void insertarFacturaProducto(int idFactura,int idProducto, int cantidad);
	
}
