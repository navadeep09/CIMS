package cm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.connect;

public class Customerdetails {
	int customerid;
	String name;
	public Customerdetails(int customerid, String name) {
		this.customerid = customerid;
		this.name = name;
	}
	private Connection conn = connect.getConnection();	
	
	public void customerdet() {
		final String query = "SELECT * FROM Customer WHERE customer_id = ? AND name = ?";
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, customerid);
        preparedStatement.setString(2, name);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("customer_id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            long phone_number = rs.getLong("phone_number");
            String address = rs.getString("address");

            System.out.println("Customer Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phone_number);
            System.out.println("Address: " + address);
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
