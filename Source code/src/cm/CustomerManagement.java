package cm;

import java.util.Scanner;

public class CustomerManagement {
	Scanner sc = new Scanner(System.in);
	public void prin() {
		while(true) {
			System.out.println("1.Register a new customer\n"
					+ "2.View customer details\n"
					+ "3.Update customer information\n"
					+ "4.Delete a customer\n"
					+ "5.Exit\n"
					+"Select one option from above");
			int option = sc.nextInt();
			switch (option) {
			case 1 :
				System.out.println("Enter Customer name");
				String name = sc.next();
				System.out.println("Enter Customer Email");
				String email = sc.next();
				System.out.println("Enter Customer Phone-Number");
				long phonenumber = sc.nextLong();
				System.out.println("Enter Customer Address");
				String address = sc.next();
				Registernewcustomer rnc = new Registernewcustomer(name,email,phonenumber,address);
				rnc.newcustomer();
				break;
			case 2 :
				System.out.println("Enter Customer ID");
				int customerid = sc.nextInt();
				System.out.println("Enter Customer name");
				String name1 = sc.next();
				Customerdetails cd = new Customerdetails(customerid, name1);
				cd.customerdet();
				break;
			case 3:
				System.out.println("Enter Customer ID");
				int customerid1 = sc.nextInt();
				System.out.println("Enter Customer name");
				String name2 = sc.next();
				System.out.println("Enter Customer Email");
				String email1 = sc.next();
				System.out.println("Enter Customer Phone-Number");
				long phonenumber1 = sc.nextLong();
				System.out.println("Enter Customer Address");
				String address1 = sc.next();
				Updatecustomer uc = new Updatecustomer(customerid1, name2, email1, phonenumber1, address1);
				uc.updatpol();
				break;
			case 4:
				System.out.println("Enter Customer ID");
				int customerid2 = sc.nextInt();
				System.out.println("Enter Customer name");
				String name3 = sc.next();
				Deletecustomer dc = new Deletecustomer(customerid2, name3);
				dc.delcust();
				break;
			}
			if (option == 5)
				break;
		}
		
	}
}
