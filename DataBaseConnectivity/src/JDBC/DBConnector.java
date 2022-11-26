package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;






public class DBConnector extends DBConx {
	 /*
	   * DataBase Singleton 
	   */
	  private static DBConnector connector;
	 
	  private DBConnector(String DB,String User,String Password,boolean exist) {
		  super(DB,User,Password);
	  }
	  public static DBConnector getInstenceDB(String DB,String User,String Password,boolean exist) {
		  if(DBConnector.connector==null) {
			  DBConnector.connector=new DBConnector( DB, User, Password,exist);
			  Connect(exist);
		  }
		  return DBConnector.connector;
	  }
	 
	 
}
