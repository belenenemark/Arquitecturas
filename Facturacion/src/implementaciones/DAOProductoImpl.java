package implementaciones;

import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import facturacion.Conexion;
import facturacion.Producto;
import interfaces.DAOProducto;

public class DAOProductoImpl extends Conexion implements DAOProducto {

	@Override
	public void crearTabla() throws SQLException {
		this.conectar();
		String table="CREATE TABLE producto (" + 
				"				     idproducto INT NOT NULL ," + 
				"				    nombre varchar(45) NOT NULL," + 
				"				    valor float  NOT NULL ," + 
				"				   PRIMARY KEY (idproducto)" + 
				"				);";
	this.conn.prepareStatement(table).execute();
	this.conn.commit();	
	this.cerrarConexion();
		
	}

	@Override
	public void agregarProducto(Producto pr) throws SQLException {
		this.conectar();
		String insert= "insert into Producto (idproducto,nombre,valor) VALUES (?,?,?)";
		PreparedStatement ps = this.conn.prepareStatement(insert);
		ps.setInt(1, pr.getIdProducto());
		ps.setString(2, pr.getNombre());
		ps.setFloat(3, pr.getValor());
		ps.executeUpdate();
		ps.close();
		this.conn.commit();
		this.cerrarConexion();
		
	}

	@Override
	public void actualizarProducto(Producto pr, Producto pr2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarProducto(Producto pr) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> listarProductos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarDesdeCsv() throws SQLException {
		CSVParser parser;
		Producto p;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("C://Users/Grido/Desktop/Facultad/arqui web/csvs/productos.csv"));
			for(CSVRecord row: parser) {
				 p=new Producto(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Float.parseFloat(row.get("valor")));
				System.out.println(row.get("idProducto"));
				System.out.println(row.get("nombre"));
				System.out.println(row.get("valor"));
				this.agregarProducto(p);
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		
	}

}
