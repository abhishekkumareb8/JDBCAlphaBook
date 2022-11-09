package jdbc_eb8;

import java.util.Scanner;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean b= true;
		while(b)
		{
			System.out.println("Enter the operation to perform\n1: Insert the Student detail\n2: Update the Student detail\n3: Delete the Student detail\n4: Read the Student Detailon basis of ID\n5: Read details of All Student\n6: Exit");
			System.out.println("---------------------------------");
			int choice= scanner.nextInt();
			switch(choice)
			{
				case 1:{
						System.out.println("Enter the id");
						int id= scanner.nextInt();
						
						System.out.println("Enter the name");
						String name= scanner.next();
						
						System.out.println("Enter the phone number");
						long phone=scanner.nextLong();
						
						Employee employee=new Employee();
						employee.setId(id);
						employee.setName(name);
						employee.setPhone(phone);
						
						EmployeeCRUD employeeCRUD= new EmployeeCRUD();
						try {
							employeeCRUD.saveDetail(employee);
							System.out.println("=====================");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				case 2:{
					System.out.println("Enter the id to be updated");
					int id= scanner.nextInt();
					
					System.out.println("Enter the new phone number");
					long phone=scanner.nextLong();
					Employee employee=new Employee();
					employee.setId(id);
					employee.setPhone(phone);
					EmployeeCRUD employeeCRUD= new EmployeeCRUD();
					try {
						employeeCRUD.updateDeatail(id, employee);
						System.out.println("=====================");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				case 3:
				{
					System.out.println("Enter the id to delete");
					int id=scanner.nextInt();
					Employee employee=new Employee();
					employee.setId(id);
					EmployeeCRUD employeeCRUD= new EmployeeCRUD();
					try {
						employeeCRUD.deleteDetail(id);
						System.out.println("=====================");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
				case 4:
				{
					System.out.println("Enter the id to be displayed");
					int id=scanner.nextInt();
					Employee employee=new Employee();
					employee.setId(id);
					EmployeeCRUD employeeCRUD= new EmployeeCRUD();
					try {
						employeeCRUD.readById(id);
						System.out.println("=====================");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				break;
				case 5:
				{
					Employee employee=new Employee();
					EmployeeCRUD employeeCRUD= new EmployeeCRUD();
					try {
						employeeCRUD.readDetail();
						System.out.println("=====================");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				case 6:
				{
					b=false;
					System.out.println("Thanks for using our app");
				}

}
		}
	}
}
