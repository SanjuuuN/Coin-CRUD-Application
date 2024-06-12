package com.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Coin;

public class DataConnect implements DataAccess {

	@Override
	public void create(Coin coin) {
	
		 Connection con = null;
		    PreparedStatement insertstmt = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		        String dmlinsertquery = "INSERT INTO coin VALUES(?,?,?,?)";
		        insertstmt = con.prepareStatement(dmlinsertquery);
		        insertstmt.setString(1,coin.getCoinName());
		        insertstmt.setString(2,coin.getCoinQuantity());
		        insertstmt.setString(3,coin.getValue());
		        insertstmt.setString(4,coin.getCountryOfOrigin());
		        

		        insertstmt.executeUpdate();
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (insertstmt != null) {
		                insertstmt.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
	}


//
//	@Override
//	public Coin read(String coinName) {
//	    Connection con = null;
//	    PreparedStatement selectStmt = null;
//	    ResultSet resultSet = null;
//	    Coin coin = null;
//
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
//
//	        String selectQuery = "SELECT * FROM coin WHERE coinName=?";
//	        selectStmt = con.prepareStatement(selectQuery);
//	        selectStmt.setString(1, coinName);
//
//	        resultSet = selectStmt.executeQuery();
//
//	        if (resultSet.next()) {
//	            // If result is found, create a Coin object
//	            coin = new Coin();
//	            coin.setCoinName(resultSet.getString("coinName"));
//	            coin.setCoinQuantity(resultSet.getString("coinQuantity"));
//	            coin.setValue(resultSet.getString("value"));
//	            coin.setCountry(resultSet.getString("country"));
//	        }
//	    } catch (ClassNotFoundException | SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            if (resultSet != null) {
//	                resultSet.close();
//	            }
//	            if (selectStmt != null) {
//	                selectStmt.close();
//	            }
//	            if (con != null) {
//	                con.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    return coin;
//	}
//



	public boolean delete(String coinName) {
	    Connection con = null;
	    PreparedStatement deletestmt = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

	        String dmldeletequery = "DELETE FROM coin WHERE coinName=?";
	        deletestmt = con.prepareStatement(dmldeletequery);
	        deletestmt.setString(1, coinName);

	        int rowsAffected = deletestmt.executeUpdate();

	        // Check if any rows were affected (i.e., deletion was successful)
	        if (rowsAffected > 0) {
	            return true; // Deletion successful
	        } else {
	            // If no rows were affected, coin with given name doesn't exist
	            return false; // Deletion failed
	        }
	    } catch (ClassNotFoundException e) {
	        // Log error and return custom error message
	        System.err.println("MySQL JDBC Driver not found");
	        e.printStackTrace();
	        return false; // Deletion failed
	    } catch (SQLException e) {
	        // Log error and return custom error message
	        System.err.println("Error executing SQL query: " + e.getMessage());
	        e.printStackTrace();
	        return false; // Deletion failed
	    } finally {
	        // Close resources in the finally block
	        try {
	            if (deletestmt != null) {
	                deletestmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            // Log error while closing resources
	            System.err.println("Error closing database resources: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}




	@Override
	public void update(String coinnametoupdate,String coinvaluetoupdate) {
		// TODO Auto-generated method stub
		Connection con = null;
	    PreparedStatement updatestmt = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
	        
	        
	        String updateQuery = "UPDATE coin set value=? where coinName=?";
	        
	        updatestmt = con.prepareStatement(updateQuery);
	        updatestmt.setString(1, coinvaluetoupdate);     
	        updatestmt.setString(2, coinnametoupdate);     
	        int rows=updatestmt.executeUpdate();
	        System.out.println(rows);
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (updatestmt != null) {
	            	updatestmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}





	@Override
	public List<Coin> getAllcoins() {
		List<Coin> coins = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

            String query = "SELECT * FROM coin";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Coin coin = new Coin();
                coin.setCoinName(rs.getString("coinName"));
                coin.setCoinQuantity(rs.getString("coinQuantity"));
                coin.setValue(rs.getString("coinValue"));
                coin.setCountry(rs.getString("coinCountry"));
                coins.add(coin);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return coins;
	}


	@Override
	public List<Coin> getAllCoins() {
		List<Coin> coins = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

            String query = "SELECT * FROM coin";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Coin coin = new Coin();
                coin.setCoinName(rs.getString("coinName"));
                coin.setCoinQuantity(rs.getString("coinQuantity"));
                coin.setValue(rs.getString("coinValue"));
                coin.setCountry(rs.getString("coinCountry"));
                coins.add(coin);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return coins;
	}


	



}
