package pm;
import java.util.Scanner;

public class PolicyManagement {
	Scanner sc = new Scanner(System.in);
	public void prin() {
		while(true) {
			System.out.println("1.Add a new policy\n"
					+ "2.View policy details\n"
					+ "3.Update policy information\n"
					+ "4.Delete a policy\n"
					+ "5.Exit\n"
					+"Select one option from above");
			int option = sc.nextInt();
			switch (option) {
			case 1 :
				System.out.println("enter policy number");
				String Policynumber = sc.next();
				System.out.println("enter policy type");
				String type = sc.next();
				System.out.println("enter policy coverageamount");
				float coverageamount = sc.nextFloat();
				System.out.println("enter policy premiumamount");
				float premiumamount = sc.nextFloat();
				Newpolicy np = new Newpolicy(Policynumber, type, coverageamount, premiumamount );
				np.newpo();
				break;
			case 2 :
				System.out.println("enter policy ID");
				int policyid = sc.nextInt();
				System.out.println("enter policy number");
				String Poliynumber = sc.next();
				Policydetails pd = new Policydetails(policyid,Poliynumber);
				pd.polidetai();
				break;
			case 3:
				System.out.println("enter policy ID");
				int policyid1 = sc.nextInt();
				System.out.println("enter policy number");
				String Policynumber1 = sc.next();
				System.out.println("enter policy type");
				String type1 = sc.next();
				System.out.println("enter policy coverageamount");
				float coverageamount1 = sc.nextFloat();
				System.out.println("enter policy premiumamount");
				float premiumamount1 = sc.nextFloat();
				Updatepolicy up = new Updatepolicy(policyid1,Policynumber1,type1,coverageamount1,premiumamount1);
				up.updatpol();
				break;
			case 4:
				System.out.println("enter policy ID");
				int policyid2 = sc.nextInt();
				System.out.println("enter policy number");
				String Policynumber2 = sc.next();
				Deletepolicy dp = new Deletepolicy(policyid2, Policynumber2);
				dp.delpoli();
				break;
			}
			if (option == 5)
				break;
		}
		
	}
}
