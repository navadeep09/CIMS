package cm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Updatecustomer {
	int customerid;
	String name,email;
	long phonenumber;
	String address;
	public Updatecustomer(int customerid, String name, String email, long phonenumber, String address) {
		this.customerid = customerid;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	private Connection conn = connect.getConnection();
	public void updatpol() {
		final String query = "UPDATE Customer SET email = ?, phone_number = ?, "
				+ "address = ? WHERE customer_id = ? AND name = ?";
		try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setLong(2, phonenumber);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, customerid);
            preparedStatement.setString(5, name);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Policy updated successfully.");
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
