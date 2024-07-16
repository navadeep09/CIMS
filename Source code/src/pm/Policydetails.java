package pm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connect.connect;

public class Policydetails {
	int policyid;
	String policynumber;
	public Policydetails(int policyid, String policynumber) {
		this.policyid = policyid;
		this.policynumber = policynumber;
	}
	private Connection conn = connect.getConnection();	
	
	public void polidetai() {
		final String query = "SELECT * FROM Policy WHERE policy_id = ? AND policy_number = ?";
		try {
		PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, policyid);
        preparedStatement.setString(2, policynumber);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("policy_id");
            String number = rs.getString("policy_number");
            String type = rs.getString("type");
            float coverage = rs.getFloat("coverage_amount");
            float premium = rs.getFloat("premium_amount");

            System.out.println("Policy ID: " + id);
            System.out.println("Policy Number: " + number);
            System.out.println("Type: " + type);
            System.out.println("Coverage Amount: " + coverage);
            System.out.println("Premium Amount: " + premium);
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
