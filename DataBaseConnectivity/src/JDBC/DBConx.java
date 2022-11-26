package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/***
 * @author YAKOUB anouar
 */
public abstract class DBConx {
	  /***
	   * DataBase tools
	   */
	  private static Connection con;
	  private static PreparedStatement pat;
	  private static ResultSet rs;
	  /***
	   * DataBase Informations
	   */
	  private final static String DB_url="jdbc:mysql://localhost:4306/";
	  private static  String DB,User,Password;
	 
	protected DBConx (String DB,String User,String Password){
		DBConx.DB=DB;DBConx.User=User;DBConx.Password=Password;
	};
	protected static void Connect(boolean exist)  {
		 System.out.println("Connecting to a selected database...");
			try {
				setConObj(DriverManager.getConnection(DB_url+(exist ==true ? DB:""),User,Password));
				System.out.println("Connection was done!");
				if(!exist) {
					 String query = "CREATE DATABASE "+DB;
					 setPatObj(getConObj().prepareStatement(query));
					 getPatObj().execute();
			         System.out.println(DB+" created successfully...");  
				}
				
			}
			catch( SQLException ex) { 
				System.out.println("SQLException!");
			} 
		}


	
	/***
	 * 
	 * (geter & seter)s
	 */
	protected static Connection getConObj() {
		return DBConx.con;
	}
	protected  static void setConObj(Connection con) {
		DBConx.con = con;
	}
	protected static  PreparedStatement getPatObj() {
		return DBConx.pat;
	}
	protected static  void setPatObj(PreparedStatement pat) {
		DBConx.pat = pat;
	}
	protected static  ResultSet getRsObj() {
		return DBConx.rs;
	}
	protected  static void setRsObj(ResultSet rs) {
		DBConx.rs = rs;
	}
}
