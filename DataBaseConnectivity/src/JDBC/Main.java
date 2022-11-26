package JDBC;



public class Main {
	  static String DB="HelloWord",User="root",PassWord ="";
		public static void main(String[] args)  {
			/**
			 * 
			 * create a HelloWord Database 
			 * 
			 * */
			DBConnector myConx =DBConnector.getInstenceDB(DB,User,PassWord,false);
	    
		}
}
