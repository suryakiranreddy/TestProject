package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class JDBC_Connection {
	Connection conn = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	String data="";
	public String jdbcConnection(String querry, String columnName) throws SQLException, ClassNotFoundException{
	//String query = String.format("select PAN from users where phone_home="+phone_num);
	//String query = String.format(querry);
	 Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://52.201.100.74:3306/cmol_uat", "developer", "D3V3L0P3R@321go");
	stmt = conn.createStatement();
	resultSet = stmt.executeQuery(querry);
	while (resultSet.next()) {
	   // data =resultSet.getString("PAN");
		data =resultSet.getString(columnName);
	}
	resultSet.close();
	stmt.close();
	conn.close();
	return data;
	}
	
	@Test
	public void data() throws ClassNotFoundException, SQLException{
		String pan=jdbcConnection("select PAN from users where phone_home=7944088933", "PAN");
		System.out.println("pan number :-"+pan);//dfgfy3444g
	}
	
}
