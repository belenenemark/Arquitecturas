package implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import facturacion.Cliente;
import facturacion.Conexion;
import interfaces.DAOCliente;

public class DAOClienteImpl extends Conexion implements DAOCliente {

	public void crearTabla() throws SQLException {
		this.conectar();
		String table="CREATE TABLE cliente (" + 
				"     id INT NOT NULL AUTO_INCREMENT," + 
				"     nombre VARCHAR(500) NOT NULL," + 
				"     mail varchar(150)," + 
				"     PRIMARY KEY (id)" + 
				");";
	this.conn.prepareStatement(table).execute();
	this.conn.commit();	
	this.cerrarConexion();
	}
	
	public void agregarCliente(Cliente c) throws SQLException {
		this.conectar();
		String insert= "insert into Cliente (nombre,mail) VALUES (?,?)";
		PreparedStatement ps = this.conn.prepareStatement(insert);
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getEmail());
		ps.executeUpdate();
		ps.close();
		this.conn.commit();
		this.cerrarConexion();
	}

	public void actualizarCliente(Cliente c, Cliente c2) throws SQLException {
		this.conectar();
		String update= "update Cliente SET nombre = ?, mail = ? WHERE id = ?";
		PreparedStatement ps = this.conn.prepareStatement(update);
			ps.setString(1, c2.getNombre());
			ps.setString(2, c2.getEmail());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
			ps.close();
			this.conn.commit();
			this.cerrarConexion();		
	}

	@Override
	public void borrarCliente(Cliente c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listarClientes() throws SQLException {
		this.conectar();
		String select = "select * from cliente";
		PreparedStatement ps = this.conn.prepareStatement(select);
		ResultSet rs=ps.executeQuery();
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
			conn.close();
		return result;
	}

}
