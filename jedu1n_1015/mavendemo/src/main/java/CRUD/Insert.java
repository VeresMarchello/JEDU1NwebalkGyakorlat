package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert
{
	public static void fillCats(Connection connection, int id, String nev, String breed, int age, String owner)
	{
		try
		{	
			connection.setAutoCommit(false);

			PreparedStatement st = connection.prepareStatement("INSERT INTO CATS VALUES (?, ?, ?, ?, ?)");
			st.setInt(1, id);
			st.setString(2, nev);
			st.setString(3, breed);
			st.setInt(4, age);
			st.setString(5, owner);
			
			int db = st.executeUpdate();	
			System.out.println(db + " RECORD ADDED TO CATS");
			System.out.println();
			
			connection.commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
