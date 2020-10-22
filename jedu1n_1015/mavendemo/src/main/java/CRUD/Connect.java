package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect
{
	public static Connection connect(String connectionString, String username, String password)
	{

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connectionString, username, password);
			System.out.println("CONNECTED");
			System.out.println();

			return conn;

		}
		catch (Exception e)
		{
			System.out.println("INVALID CREDENTIALS");
			System.out.println("NOT CONNECTED");
			e.printStackTrace();
			return null;
		}
	}

	public static void disconnect(Connection connection)
	{

		if (connection != null)
		{

			try
			{
				connection.close();
				System.out.println("DISCONNECTED\n");
			}

			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		}
	}

}
