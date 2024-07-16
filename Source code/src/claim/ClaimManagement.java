package claim;

import java.sql.Date;
import java.util.Scanner;

public class ClaimManagement {
	Scanner sc = new Scanner(System.in);
	public void prin() {
		while(true) {
			System.out.println("1.Register a new claim\n"
					+ "2.View claim details\n"
					+ "3.Update claim information\n"
					+ "4.Delete a claim\n"
					+ "5.Exit\n"
					+"Select one option from above");
			int option = sc.nextInt();
			switch (option) {
			case 1 :
			    System.out.print("Enter policy_id: ");
	            int policyId = sc.nextInt();
	            System.out.print("Enter customer_id: ");
	            int customerId = sc.nextInt();
	            System.out.print("Enter claim_date (YYYY-MM-DD): ");
	            String claimDateString = sc.next();
	            System.out.print("Enter status (submitted/processed): ");
	            String status = sc.next();
	            Date claimDate = Date.valueOf(claimDateString);
	            Registernewclaim rnc = new Registernewclaim(policyId, customerId, claimDate, status);
	            rnc.regnewcla();
				break;
			case 2 :
				System.out.print("Enter Claim_id: ");
				int Claimid = sc.nextInt();
				Viewclaim vc = new Viewclaim(Claimid);
				vc.viewcla();
				break;
			case 3:
				System.out.print("Enter Claim_id: ");
				int Claimid1 = sc.nextInt();
				System.out.print("Enter status (submitted/processed): ");
				String status1 = sc.next();
				Updateclaim uc = new Updateclaim(Claimid1, status1);
				uc.updtcl();
				break;
			case 4:
				System.out.print("Enter Claim_id: ");
				int Claimid2 = sc.nextInt();
				Deleteclaim delc = new Deleteclaim(Claimid2);
				delc.delclaim();
				break;
			}
			if (option == 5)
				break;
		}
		
	}
}
