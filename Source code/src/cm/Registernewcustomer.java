package cm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Registernewcustomer {
	String name,email;
	long phonenumber;
	String address;
	public Registernewcustomer(String name, String email, long phonenumber, String address) {
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	private Connection conn = connect.getConnection();
	
	public void newcustomer() {
		final String query = "INSERT INTO Customer (name, email, phone_number,"
				+ " address) VALUES (?, ?, ?, ?)";		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setLong(3, phonenumber);
            preparedStatement.setString(4, address);
            int rs = preparedStatement.executeUpdate();  
			if (rs==1)
				System.out.println("Sucessfully new customer created");
		}
		catch (Exception e) {
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
