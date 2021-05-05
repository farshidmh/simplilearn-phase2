package com.sample.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductService {

	public static void newProduct(DbConnector dbConnector, String name, int cat, int price) throws SQLException {

		PreparedStatement pstmp = dbConnector.getConnection()
				.prepareStatement("insert into tbl_product (name,cat,price) values (?,?,?)");

		pstmp.setString(1, name);
		pstmp.setInt(2, cat);
		pstmp.setInt(3, price);
		pstmp.executeUpdate();

		pstmp.close();

		dbConnector.getConnection().close();

	}

	public static void deleteProduct(DbConnector dbConnector, int pid) throws SQLException {

		PreparedStatement pstmp = dbConnector.getConnection()
				.prepareStatement("delete from tbl_product where  product_id=?");

		pstmp.setInt(1, pid);
		pstmp.executeUpdate();

		pstmp.close();

		dbConnector.getConnection().close();

	}
	
	public static void updateProduct(DbConnector dbConnector, int pid, String name) throws SQLException {
		
		PreparedStatement pstmp = dbConnector.getConnection()
				.prepareStatement("update tbl_product set name=? where product_id=?");

		pstmp.setString(1, name);
		pstmp.setInt(2, pid);
		
		pstmp.executeUpdate();

		pstmp.close();

		dbConnector.getConnection().close();
		
		
		
	}
	
	
	public static String getProductName(DbConnector dbConnector, int pid) throws SQLException {
		
		PreparedStatement pstmp = dbConnector.getConnection()
				.prepareStatement("select name from tbl_product where product_id=?",
						ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);

		pstmp.setInt(1, pid);
		
		ResultSet rst = pstmp.executeQuery();

		rst.first();
		
		String temp = rst.getString(1);
		
		
		
		pstmp.close();

		dbConnector.getConnection().close();
		
		
		return temp;
		
		
	}

}
