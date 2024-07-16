package pm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.connect;

public class Updatepolicy {
	int policyid;
	String policynumber,newType;
	float newCoverageAmount;
	float newPremiumAmount;
	public Updatepolicy(int policyid, String policynumber, String newType, float newCoverageAmount,float newPremiumAmount) {
		this.policyid = policyid;
		this.policynumber = policynumber;
		this.newType = newType;
		this.newCoverageAmount = newCoverageAmount;
		this.newPremiumAmount = newPremiumAmount;
	}
	private Connection conn = connect.getConnection();	
	public void updatpol() {
		final String query = "UPDATE Policy SET type = ?, coverage_amount = ?, "
				+ "premium_amount = ? WHERE policy_id = ? AND policy_number = ?";
		try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, newType);
            preparedStatement.setFloat(2, newCoverageAmount);
            preparedStatement.setFloat(3, newPremiumAmount);
            preparedStatement.setInt(4, policyid);
            preparedStatement.setString(5, policynumber);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Policy updated successfully.");
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
