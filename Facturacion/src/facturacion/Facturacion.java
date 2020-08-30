package facturacion;

import java.sql.SQLException;
import java.sql.Statement;

import implementaciones.DAOClienteImpl;
import interfaces.DAOCliente;

public class Facturacion {
	private static int refId = 0;
	
	
	public static void main(String[] args) throws SQLException {
		Cliente c = new Cliente("Belen", "belenenemar@gmail.com");
		DAOCliente daoc = new DAOClienteImpl();
		//daoc.crearTabla();
		daoc.agregarCliente(c);
//		refId++;
	//	System.out.println(refId);

		//System.out.println(c.getId());
		//Cliente c2 = new Cliente("Juan", "belenenemar@gmail.com");
		//daoc.actualizarCliente(c, c2);
		daoc.listarClientes();
	}

}
