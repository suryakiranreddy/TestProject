package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class JDBC_Connection {
Connection conn = null;
Statement stmt = null;
ResultSet resultSet = null;
String data;
ArrayList<String> arrlist = new ArrayList<String>();

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

public Map<Object, Object> jdbcConnection(String querry) throws SQLException, ClassNotFoundException{
	//String query = String.format("select * from users where phone_home=7944088933");
	//String query = String.format(querry);
	 Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://52.201.100.74:3306/cmol_uat", "developer", "D3V3L0P3R@321go");
	stmt = conn.createStatement();
	resultSet = stmt.executeQuery(querry);
	Map<Object, Object> map = new HashMap<>();
	while (resultSet.next()) {
	    ResultSetMetaData md = resultSet.getMetaData();
	    int colCount = md.getColumnCount();
	    
	    for (int i = 1; i <= colCount ; i++){
	        String col_name = md.getColumnName(i);
	        data=resultSet.getString(col_name);
	        map.put(col_name, data);
	        System.out.println(data); 
	        arrlist.add(data);
	       // System.out.println(arrlist);
	        
	        //System.out.println(col_name+" - "+resultSet.getString(col_name));
	    }

	}
	resultSet.close();
	stmt.close();
	conn.close();
	//return data;
	return map;
	}


@Test
public void data() throws ClassNotFoundException, SQLException{
	//String pan=jdbcConnection("select PAN from users where phone_home=7944088933", "PAN");
	//System.out.println("pan number :-"+pan);//dfgfy3444g
	
	Map<Object, Object> returnedDataMap = jdbcConnection("select * from users where phone_home=7944088933");
	System.out.println(returnedDataMap);
	//String data2=jdbcConnection("select * from users where phone_home=7944088933");
	//System.out.println(data2);
}

}