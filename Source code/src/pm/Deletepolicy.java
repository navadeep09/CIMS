package pm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Deletepolicy {
	int policyid;
	String policynumber;
	public Deletepolicy(int policyid, String policynumber) {
		this.policyid = policyid;
		this.policynumber = policynumber;
	}
	private Connection conn = connect.getConnection();	
	
	public void delpoli() {
        final String query = "DELETE FROM Policy WHERE policy_id = ? AND policy_number = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, policyid);
	        preparedStatement.setString(2, policynumber);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Policy deleted successfully.");
	        } else {
	            System.out.println("No policy found with ID " + policyid + " and number " + policynumber);
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
