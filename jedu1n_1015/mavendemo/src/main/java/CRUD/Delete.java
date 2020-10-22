package CRUD;

import java.sql.Connection;
import java.sql.Statement;

public class Delete
{
	public static void deleteCats(Connection connection, String column1, String value1, String column2, String value2)
	{
		try
		{
			Statement st = connection.createStatement();
			
			int count = st.executeUpdate("DELETE FROM CATS WHERE " + column1 + " = '" + value1 + "'" + "AND " + column2 + " = '" + value2 + "'" );
		
			System.out.println(count + " ROW(S) DELETED\n");
			connection.commit();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
