package cm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Deletecustomer {

	int customerid;
	String name;
	public Deletecustomer(int customerid, String name) {
		this.customerid = customerid;
		this.name = name;
	}
	private Connection conn = connect.getConnection();	
	
	public void delcust() {
		final String query = "DELETE FROM Customer WHERE customer_id = ? AND name = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, customerid);
	        preparedStatement.setString(2, name);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Customer deleted successfully.");
	        } else {
	            System.out.println("No Customer found with ID " + customerid + " and name " + name);
	        }
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
            	System.out.println(e.getMessage());
            }
        }
	}
}

