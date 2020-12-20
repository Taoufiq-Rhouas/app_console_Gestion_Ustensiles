import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


public class Conection {

	Connection conn;
	Statement stat;
	ResultSet rs;
	
	public void Connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_des_ustensiles", "testetoto" , "test1234");
			//System.out.println("ok");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
