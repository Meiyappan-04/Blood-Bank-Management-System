package com.wipro.bloodbank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
		private static Connection con;
		public static Connection getDBConnection() {
			if(con==null) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return con;
		}
}
