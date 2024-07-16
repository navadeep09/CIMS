package claim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Deleteclaim {
	int claimid;
	public Deleteclaim(int claimid) {
		this.claimid = claimid;
	}
	private Connection conn = connect.getConnection();	
	public void delclaim() {
		final String query = "DELETE FROM Claim WHERE claim_id = ? ";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, claimid);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Policy deleted successfully.");
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
	


