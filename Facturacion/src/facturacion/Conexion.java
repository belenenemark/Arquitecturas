package facturacion;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexion {

	protected Connection conn;
	protected String uri="jdbc:mysql://localhost:3306/exampledb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	protected String user = "root";
	protected String pass = "";
	protected String driver="com.mysql.cj.jdbc.Driver";
	
	public void conectar() {
	
			try {
				Class.forName(driver).getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
						e.printStackTrace();
						System.exit(1);
			}
			
			try {
				conn= DriverManager.getConnection(uri,user,pass);
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public void cerrarConexion() throws SQLException {
		if (conn != null) {
			if (!conn.isClosed()){
				conn.close();		
			}
		}
	}
	
public Conexion() {
	// TODO Auto-generated constructor stub
}

}