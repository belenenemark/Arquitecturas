package arqui.main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import arqui.dao.DAOCliente;
import arqui.dao.DAOFactura;
import arqui.dao.DAOProducto;
import arqui.dao.mysql.DAOClienteMysql;
import arqui.dao.mysql.DAOFacturaMysql;
import arqui.dao.mysql.DAOProductoMysql;
import arqui.modelo.Cliente;
import arqui.modelo.Factura;
import arqui.modelo.Producto;
public class test {

	private static final String path = "C:/Users/Mateo/Desktop/ARQUI/";
	
	public static void main(String[] args) throws SQLException {
		DAOCliente cliente = new DAOClienteMysql("localhost", "root", "password", "ExampleDB");
		DAOProducto producto = new DAOProductoMysql("localhost", "root", "password", "ExampleDB");
		DAOFactura factura = new DAOFacturaMysql("localhost", "root", "password", "ExampleDB");

		//CREACION DE TABLAS
		cliente.crearTabla();
		producto.crearTabla();
		factura.crearTabla();

		//CARGA DE TABLAS DESDE CSV
		cargarClientes(cliente);
		cargarProductos(producto);
		cargarFactura(factura);



	}



	public static void cargarClientes(DAOCliente cliente) {
		CSVParser parser;
		Cliente c;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path+"clientes.csv"));
			for(CSVRecord row: parser) {
				c = new Cliente(Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email"));
				cliente.insertar(c);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Se cargaron con exito los cliente, desde el archivo csv");
		}
	}
	
	public static void cargarProductos(DAOProducto producto) {
		CSVParser parser;
		Producto p;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path+"productos.csv"));
			for(CSVRecord row: parser) {
				 p= new Producto(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Float.parseFloat(row.get("valor")));
				producto.insertar(p);
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Se cargaron con exito los productos, desde el archivo csv");
		}
	}
	
	public static void cargarFactura(DAOFactura factura) {
		CSVParser parser;
		Factura f;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path+"facturas.csv"));
			for(CSVRecord row: parser) {
				f = new Factura(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente")));
				factura.insertar(f);
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Se cargaron con exito todas las facturas, desde el archivo csv");
		}
		
		//CARGA LA RELACION CON FACTURA_PRODUCTO
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path+"facturas-productos.csv"));
			for(CSVRecord row: parser) {
				factura.insertarFacturaProducto(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")), Integer.parseInt(row.get("cantidad")));;
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Se cargaron con exito la relacion entre facturas y productos, desde el archivo csv");
		}
		
	}
}