package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select
{

	public static ResultSet selectCats(Connection connection, int age)
	{
		ResultSet rs = null;

		try
		{
			connection.setAutoCommit(false);
			
			PreparedStatement st = connection.prepareStatement("SELECT * FROM CATS WHERE age >= ?");
			st.setInt(1, age);

			rs = st.executeQuery();

			connection.commit();

			return rs;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static void print(ResultSet rs)
	{

		try
		{

			while (rs.next())
			{
				System.out.println("ID: " + rs.getInt(1) + " NAME: " + rs.getString(2) + " BREED: " + rs.getString(3)
						+ " AGE: " + rs.getInt(4) + " OWNER: " + rs.getString(5));
			}
			System.out.println();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
