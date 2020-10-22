package CRUD;

import java.sql.Connection;
import java.sql.ResultSet;

import CRUD.Select;
import storedProcedure.InResultSet;

public class App
{

	public static void main(String[] args)
	{
		String connectionString = "jdbc:mysql://localhost:3306/cats?serverTimezone=UTC";
		String username = "jedu1n";
		String password = "password";

		Connection connection = Connect.connect(connectionString, username, password);
		
		ResultSet rs = Select.selectCats(connection, 1);
		Select.print(rs);

//		rs = Select.selectCats(connection, 5);
//		Select.print(rs);

//		Insert.fillCats(connection, 5, "Cicca", "Namíbiai", 1, "Gipsz Jakab");
//		
//		rs = Select.selectCats(connection, 5);
//		Select.print(rs);
		
//		Update.update(connection, "CATS", "OWNER", "Piros Ferenc", "BREED", "=", "Perzsa");
		
//		Delete.deleteCats(connection, "NAME", "Cicca", "OWNER", "Gipsz Jakab");
		
		InResultSet.selectBasedOnOwner(connection, "Piros Ferenc");
		
		Connect.disconnect(connection);
	}

}
