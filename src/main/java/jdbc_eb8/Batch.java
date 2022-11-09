
package jdbc_eb8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class Batch {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee value(?,?,?)");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Entre the number of deta you want to enter");
		int data= scanner.nextInt();
		
		
		
		for(int i=0;i<data;i++)
		{
			System.out.println("Enyter the "+(i+1)+ " id");
			int id=scanner.nextInt();
			preparedStatement.setInt(1, id);
			System.out.println("Enyter the "+(i+1)+ " name");
			String name=scanner.next();
			preparedStatement.setString(2, name);
			System.out.println("Enyter the " +(i+1)+" phone number");
			long phone=scanner.nextLong();
			preparedStatement.setLong(3,phone);
			
			preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("Detailse added");
			
	}

}
