package claim;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Registernewclaim {
	int policyid,customerid;
	Date claimdate;
	String status;
	private Connection conn = connect.getConnection();
	public Registernewclaim(int policyid, int customerid, Date claimdate, String status) {
		this.policyid = policyid;
		this.customerid = customerid;
		this.claimdate = claimdate;
		this.status = status;
	}
	public void regnewcla() {
		final String query = "INSERT INTO Claim (policy_id, customer_id, claim_date, status) VALUES (?, ?, ?, ?)";		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, policyid);
            preparedStatement.setInt(2, customerid);
            preparedStatement.setDate(3, claimdate);
            preparedStatement.setString(4, status);
            int rs = preparedStatement.executeUpdate();  
			if (rs==1)
				System.out.println("Sucessfully new Claim created");
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
	


