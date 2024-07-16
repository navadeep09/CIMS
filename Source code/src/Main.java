import java.util.Scanner;

import claim.ClaimManagement;
import pm.PolicyManagement;
import cm.CustomerManagement;

public class Main  {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PolicyManagement pp = new PolicyManagement();
		CustomerManagement cm = new CustomerManagement();
		ClaimManagement claim = new ClaimManagement();
		while(true) {
			System.out.println("1.Policy Management \n2.Customer Management \n3.Claim Management\n4. Exit"
					+"\nSelection one option from above ");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				pp.prin();
				break;
			case 2:
				cm.prin();
				break;
			case 3:
				claim.prin();
				break;
			}
			if (option == 4 )
					break;
			
		}
		sc.close();
			
	}

}
