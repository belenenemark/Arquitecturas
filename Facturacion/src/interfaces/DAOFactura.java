package interfaces;

import java.sql.SQLException;
import java.util.List;
import facturacion.Factura;

public interface DAOFactura {
	
	public void crearTabla()throws SQLException;
	public void agregarFactura(Factura  p) throws SQLException;
	public void actualizarFactura(Factura p, Factura p2)throws SQLException;
	public void borrarFactura(Factura p)throws SQLException;
	public List<Factura> listarFacturas()throws SQLException;

}
