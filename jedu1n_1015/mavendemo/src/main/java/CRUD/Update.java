package CRUD;

import java.sql.Connection;
import java.sql.Statement;

public class Update
{
	public static void update(Connection connection, String tableName, String column1, String value, String column2, String operator, String condition)
	{
		try
		{
			Statement st = connection.createStatement();
			
			if (operator == null || operator == "")
				operator = "=";
			
			int count = (column2 != null && column2 != "" && condition != null && condition != "") ?
				st.executeUpdate("UPDATE " + tableName + " SET " + column1 + " = '" + value + "'" + " WHERE " + column2 + " " + operator + " '" + condition + "'") :
				st.executeUpdate("UPDATE " + tableName + " SET " + column1 + " = '" + value + "'");
		 
			System.out.println(count + " ROW(S) UPDATED\n");
			connection.commit();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
