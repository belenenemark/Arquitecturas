package arqui.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import arqui.dao.DAOFactura;
import arqui.modelo.Factura;

public class DAOFacturaMysql extends DAOConnectionMysql implements DAOFactura{

	public DAOFacturaMysql(String host, String username, String password, String database) throws SQLException {
		super(host, username, password, database);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crearTabla() {
		PreparedStatement conexion;
		String FACTURA="CREATE TABLE IF NOT EXISTS factura (" + 
				"     idfactura INT NOT NULL ," + 
				"     idcliente int NOT NULL," +   
				"     PRIMARY KEY (idfactura)," + 
				"FOREIGN KEY (idcliente) REFERENCES cliente(id)"+
				");";

		String RELACION_FACTURA_PRODUCTO ="CREATE TABLE IF NOT EXISTS `factura_producto` (" + 
				"  `idfactura` INT NOT NULL," + 
				"  `idproducto` INT NOT NULL," + 
				"  `cantidad` INT NOT NULL," + 
				"  PRIMARY KEY (`idfactura`, `idproducto`)," + 
				"    FOREIGN KEY (`idfactura`)" + 
				"    REFERENCES `factura` (`idfactura`),"+ 
				"    FOREIGN KEY (`idproducto`)" + 
				"    REFERENCES `producto` (`idproducto`));";
		try {
			conexion = conn.prepareStatement(FACTURA);
			conexion.executeUpdate();
			conexion = conn.prepareStatement(RELACION_FACTURA_PRODUCTO);
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {	
		}

	}

	@Override
	public void insertar(Factura a) {
		PreparedStatement conexion;
		String INSERT = "INSERT INTO factura (idFactura,idCliente) VALUES (?,?)";
		try {
			conexion = conn.prepareStatement(INSERT);
			conexion.setInt(1, a.getIdFactura());
			conexion.setInt(2, a.getCliente());
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
		}

	}
	
	public void insertarFacturaProducto(int idFactura,int idProducto, int cantidad) {
		PreparedStatement conexion;
		String INSERT = "INSERT INTO factura_producto (idFactura,idProducto, cantidad) VALUES (?,?,?)";
		try {
			conexion = conn.prepareStatement(INSERT);
			conexion.setInt(1, idFactura);
			conexion.setInt(2, idProducto);
			conexion.setInt(3, cantidad);
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
		}

	}

	@Override
	public void modificar(Factura a, Factura b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Factura a) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Factura> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



}
