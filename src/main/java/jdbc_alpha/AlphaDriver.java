package jdbc_alpha;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AlphaDriver {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("============Welcome to Alpha Book===========");
		boolean b=true;
		while(b)
		{
			System.out.println("Enter the operation to perform\n1:Signup \n2:Login \n3:Exit");
			int choice=scanner.nextInt();
			
			switch(choice)
			{
				case 1:{
					
					System.out.println("===========Welcome to SignUp Page=============");
					System.out.println("Enter the email id");
					String email=scanner.next();
					System.out.println("Enter the User First Name :");
					String fname=scanner.next();
					System.out.println("Enter the User Last Name :");
					String lname=scanner.next();
					System.out.println("Enter the Password :");
					String password= scanner.next();
					System.out.println("Enter the Mobile number :");
					long mobile=scanner.nextLong();
					System.out.println("Enter the Gender :");
					String gender=scanner.next();
					System.out.println("Enter the Date of Birth yyyy-mm-dd :");
					String DOB=scanner.next();
					
					
					User user=new User();
					user.setEmail(email);
					user.setFname(fname);
					user.setLname(lname);
					user.setPassword(password);
					user.setMobile(mobile);
					user.setGender(gender);
					user.setDOB(DOB);
					AlphaBook alphaBook= new AlphaBook();
					try {
						alphaBook.signUp(user);
						System.out.println();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
				case 2:{
					System.out.println("============Welcome to LogIn Page===========");
					System.out.println("Enter you email");
					String email= scanner.next();
					System.out.println("Enter your Password");
					String password= scanner.next();
					
					User user = new User();
					user.setEmail(email);
					user.setPassword(password);
					//user.setStatus(status);
					AlphaBook alphaBook= new AlphaBook();
					try {
						alphaBook.logIn(email, password, user);
						System.out.println("=========================================");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
				case 3:
				{
					b=false;
					System.out.println("=============Thanks for using the app============");
				}
				break;
				default:
					System.out.println("Kindly enter the valid input");
					break;
			}
		}
	}

}
