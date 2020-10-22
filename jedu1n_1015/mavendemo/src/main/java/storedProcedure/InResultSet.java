package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;

public class InResultSet
{
	public static void selectBasedOnOwner(Connection connection, String owner) 
	{
		try
		{
			CallableStatement callableStatement = connection.prepareCall("{call storedProcedure(?)}");
			callableStatement.setString(1, owner);
			callableStatement.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
