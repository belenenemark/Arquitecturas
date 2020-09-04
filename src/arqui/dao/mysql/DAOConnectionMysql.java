package arqui.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DAOConnectionMysql {
	
	protected Connection conn;
	
	public DAOConnectionMysql(String host, String username, String password, String database) throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+ database, username, password);	
	}

	

}
 