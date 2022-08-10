package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
//	private static String db = "jdbc:postgresql://ec2-35-168-194-15.compute-1.amazonaws.com:5432/dcpon4phnnuah";
//	private static String user = "pvkkkdrmreuhlf";
//	private static String passwd = "f75c727efbf070d520356601f3d46f4e62f66953de2f68ee307eac64c139d66a";
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