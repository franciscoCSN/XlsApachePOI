package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String db = "jdbc:postgresql://localhost:5432/cliente";
	private static String user = "postgres";
	private static String passwd = "admin";
	private static String driverConnection = "org.postgresql.Driver";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}

	static {
		
		connect();
	}
	
	SingleConnection(){
		connect();
	}
	
	private static void connect() {
		try {
		if(connection == null) {
			Class.forName(driverConnection);
			connection = DriverManager.getConnection(db,user,passwd);
			connection.setAutoCommit(false);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
