package claim;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.connect;

public class Viewclaim {
	int claimid;
	private Connection conn = connect.getConnection();
	public Viewclaim(int claimid) {
		this.claimid = claimid;
	}
	public void viewcla() {
		final String query = "SELECT * FROM Claim WHERE claim_id = ? ";
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, claimid);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int claim_id = rs.getInt("claim_id");
            int policy_id = rs.getInt("policy_id");
            int customer_id = rs.getInt("customer_id");
            Date claim_date = rs.getDate("claim_date");
            String ENUM = rs.getString("status");

            System.out.println("Claim ID: " + claim_id);
            System.out.println("Policy ID: " + policy_id);
            System.out.println("Cuatomer ID: " + customer_id);
            System.out.println("Claim Date: " + claim_date);
            System.out.println("Status: " + ENUM);
        } else {
            System.out.println("No Claim found with ID " + claimid );
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
