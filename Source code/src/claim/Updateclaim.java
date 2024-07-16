package claim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Updateclaim {
	int claimid;
	String Status;
	private Connection conn = connect.getConnection();	
	public Updateclaim(int claimid, String status) {
		this.claimid = claimid;
		this.Status = status;
	}
	public void updtcl() {
		final String query = "UPDATE Claim SET status = ?WHERE claim_id = ? ";
		try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, Status);
            preparedStatement.setInt(2, claimid);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Policy updated successfully.");
            } else {
                System.out.println("No claim found with ID " + claimid);
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
