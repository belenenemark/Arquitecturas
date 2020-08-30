package facturacion;

import java.sql.SQLException;
import java.sql.Statement;

import implementaciones.DAOClienteImpl;
import implementaciones.DAOFactProdImpl;
import implementaciones.DAOProductoImpl;
import implementaciones.DaoFacturaImpl;
import interfaces.DAOCliente;
import interfaces.DAOFactProd;
import interfaces.DAOFactura;
import interfaces.DAOProducto;

public class Facturacion {
	//private static int refId = 0;
	
	
	public static void main(String[] args) throws SQLException {
		//Cliente c = new Cliente("Belen", "belenenemar@gmail.com");
		DAOCliente daoc = new DAOClienteImpl();
		DAOFactura daof= new DaoFacturaImpl();
		DAOProducto daop= new DAOProductoImpl();
		DAOFactProd daofp= new DAOFactProdImpl();
		
		//creacion de tablas
		/*daoc.crearTabla();
		daof.crearTabla();
		daop.crearTabla();
		daofp.crearTabla();*/
		daop.cargarDesdeCsv();
		
		
		//daoc.agregarCliente(c);
//		refId++;
	//	System.out.println(refId);

		//System.out.println(c.getId());
		//Cliente c2 = new Cliente("Juan", "belenenemar@gmail.com");
		//daoc.actualizarCliente(c, c2);
		//daoc.listarClientes();
	}
	
	//leer csv 
	
	

}
