package arqui.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arqui.dao.DAOCliente;
import arqui.modelo.Cliente;

public class DAOClienteMysql extends DAOConnectionMysql implements DAOCliente{



	public DAOClienteMysql(String host, String username, String password, String database) throws SQLException {
		super(host, username, password, database);
	}

	@Override
	public void crearTabla() {
		PreparedStatement conexion;
		String TABLE = "CREATE TABLE IF NOT EXISTS cliente (" + 
				"     id INT NOT NULL AUTO_INCREMENT," + 
				"     nombre VARCHAR(500) NOT NULL," + 
				"     mail varchar(150)," + 
				"     PRIMARY KEY (id)" + 
				");";
		try {
			conexion = conn.prepareStatement(TABLE);
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {	
		}

	}

	@Override
	public void insertar(Cliente a) {
		PreparedStatement conexion;
		String INSERT = "INSERT INTO cliente (nombre,mail) VALUES (?,?)";
		try {
			conexion = conn.prepareStatement(INSERT);
			conexion.setString(1, a.getNombre());
			conexion.setString(2, a.getEmail());
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
		}

	}

	@Override
	public void modificar(Cliente a, Cliente b){
		PreparedStatement conexion;
		String UPDATE= "UPDATE cliente SET (nombre, mail) VALUES (?,?) WHERE id = ?";
		try {
			conexion = conn.prepareStatement(UPDATE);
			conexion.setString(1, b.getNombre());
			conexion.setString(2, b.getEmail());
			conexion.setInt(3, a.getId());
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
			System.out.println("Ocurrio un error al modificar el cliente id = "+a.getId());
		}

	}

	@Override
	public void eliminar(Cliente a) {
		PreparedStatement conexion;
		String UPDATE= "DELETE FROM cliente WHERE id = ?";
		try {
			conexion = conn.prepareStatement(UPDATE);
			conexion.setInt(1, a.getId());
			conexion.executeUpdate();
			conexion.close();
		} catch (Exception e) {
			System.out.println("Ocurrio un error al eliminar el cliente id = "+a.getId());
		}

	}

	@Override
	public List<Cliente> obtenerTodos() {
		PreparedStatement conexion;
		String SELECT = "SELECT * FROM cliente";
		try {
			conexion = conn.prepareStatement(SELECT);
			ResultSet rs= conexion.executeQuery();
			List<Cliente> result = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				System.out.println(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				System.out.println(rs.getString("nombre"));
				c.setEmail(rs.getString("mail"));
				System.out.println(rs.getString("mail"));
				result.add(c);
			}
			rs.close();
			conexion.close();
			return result;
		} catch (Exception e) {
			System.out.println("Ocurrio un error al obtener todos los clientes");
		} 
		return null;
	}

	@Override
	public Cliente obtener(Integer id) {
		PreparedStatement conexion;
		Cliente c = null;
		String SELECT = "SELECT * FROM cliente WHERE id = ?";
		try {
			conexion = conn.prepareStatement(SELECT);
			conexion.setInt(1, id);
			ResultSet rs = conexion.executeQuery();
			while (rs.next()) {
				c = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("mail"));
			}
			rs.close();
			conexion.close();
			return c;
		} catch (Exception e) {
			System.out.println("Ocurrio un error al obtener el cliente id = "+id);
		}
		return null;
	}

}
