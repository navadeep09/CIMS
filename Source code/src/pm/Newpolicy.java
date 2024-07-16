package pm;
import java.sql.*;
import connect.connect;
public class Newpolicy {
	String Policynumber,type;
	float coverageamount;
	float premiumamount;
	public Newpolicy(String policynumber, String type, float coverageamount, float premiumamount) {
		this.Policynumber = policynumber;
		this.type = type;
		this.coverageamount = coverageamount;
		this.premiumamount = premiumamount;
	}
	private Connection conn = connect.getConnection();
	
	public void newpo() {
		final String query = "INSERT INTO Policy (policy_number, type, coverage_amount,"
				+ " premium_amount) VALUES (?, ?, ?, ?)";		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, Policynumber);
            preparedStatement.setString(2, type);
            preparedStatement.setFloat(3, coverageamount);
            preparedStatement.setFloat(4, premiumamount);
            int rs = preparedStatement.executeUpdate();  
			if (rs==1)
				System.out.println("Sucessfully new policy created");
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
