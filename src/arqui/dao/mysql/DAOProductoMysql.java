package arqui.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import arqui.dao.DAOProducto;
import arqui.modelo.Producto;

public class DAOProductoMysql extends DAOConnectionMysql implements DAOProducto{

	public DAOProductoMysql(String host, String username, String password, String database) throws SQLException {
		super(host, username, password, database);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crearTabla() {
		PreparedStatement conexion;
		String PRODUCTO ="CREATE TABLE IF NOT EXISTS `producto` (\n" + 
				"			  `idproducto` INT NOT NULL,\n" + 
				"			  `nombre` VARCHAR(45) NOT NULL,\n" + 
				"			  `valor` FLOAT NOT NULL,\n" + 
				"			  PRIMARY KEY (`idproducto`));";
		try {
			conexion = conn.prepareStatement(PRODUCTO);
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {	
		}
		
	}

	@Override
	public void insertar(Producto a) {
		PreparedStatement conexion;
		String INSERT= "INSERT IGNORE INTO producto (idproducto,nombre,valor) VALUES (?,?,?)";
		try {
			conexion = conn.prepareStatement(INSERT);
			conexion.setInt(1, a.getIdProducto());
			conexion.setString(2, a.getNombre());
			conexion.setFloat(3, a.getValor());
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
		}
		
	}

	@Override
	public void modificar(Producto a, Producto b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Producto a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
