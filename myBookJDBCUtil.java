package com.book.mgt;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class myBookJDBCUtil {
	   public myBookJDBCUtil() {
	   }

	   public static Connection getMysqlConnection() {
	      Connection con = null;

	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost/mybookdb", "root", "SURB");
	      } catch (Exception var2) {
	         var2.printStackTrace();
	      }

	      return con;
	   }

	   public static Connection getOracleConnection() {
	      Connection con = null;

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "SURB");
	      } catch (Exception var2) {
	         var2.printStackTrace();
	      }

	      return con;
	   }

	   public static void cleanUp(Connection con, Statement st) {
	      try {
	         if (st != null) {
	            st.close();
	         }

	         if (con != null) {
	            con.close();
	         }
	      } catch (Exception var3) {
	         var3.printStackTrace();
	      }

	   }

	   public static void cleanUp(Connection con, Statement st, ResultSet rs) {
	      try {
	         if (st != null) {
	            st.close();
	         }

	         if (con != null) {
	            con.close();
	         }

	         if (rs != null) {
	            rs.close();
	         }
	      } catch (Exception var4) {
	         var4.printStackTrace();
	      }

	   }
	}

