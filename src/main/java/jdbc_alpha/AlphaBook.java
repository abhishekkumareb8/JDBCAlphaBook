package jdbc_alpha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;


public class AlphaBook {
	
	
	Connection connection = new Connectionn().getConnection();
	Scanner scanner=new Scanner(System.in);
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	public void signUp(User user) throws Exception
	{
		String query= "insert into alpha value(?,?,?,?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(query);
		
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getFname());
		statement.setString(3, user.getLname());
		statement.setString(4, user.getPassword());
		statement.setLong(5, user.getMobile());
		statement.setString(6, user.getGender());
		statement.setString(7, user.getStatus());
		statement.setString(8, user.getDOB());
		
		statement.executeUpdate();
		connection.close();
		System.out.println("==========Signup Successfull=========");
				
	}
	
	public void logIn(String email,String password,User user) throws Exception
	{
		String query="select * from alpha where email=? and password=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		
		ResultSet resultset= preparedStatement.executeQuery();
		String passd="";
		String emaild="";
		
		while(resultset.next())
		{
			emaild=resultset.getString(1);
			passd=resultset.getString(4);	
		}
		if(passd.equals(user.getPassword()) && emaild.equals(user.getEmail()))
		{
			System.out.println("*****************You are logged in successfully*****************"); 
			System.out.println("----Do you want to add Status??????\n1:Yes\n2:No");
			int status1=scanner.nextInt();
			if(status1==1)
			{
					AlphaBook alphaBook= new AlphaBook();
					alphaBook.status(emaild);

			}
			else
			{
				System.out.println(":::::::::::::::Status not added :::::::::::");
			}
			
		}
		else
		{
			System.out.println("***************Invalid Id or Password****************");
		}
		connection.close();
	}
	public void status(String email) throws Exception
	{
		
		String query= "update alpha set status=? where email=?";
		PreparedStatement preparedStatement2= connection.prepareStatement(query);
		System.out.println("Enter the status");
		String status=scanner.nextLine();
		User user1= new User();
		user1.setStatus(status);
	
		preparedStatement2.setString(1, status);
		preparedStatement2.setString(2,email);
		preparedStatement2.executeUpdate();
		System.out.println(":::::::::::::::Status added Sucessfully:::::::::::");
		
		System.out.println("Do you want to check Status??????\n1:Yes\n2:No");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			LocalDateTime l= LocalDateTime.now();
			PreparedStatement statement=connection.prepareStatement("select * from alpha where email=?");		
			statement.setString(1, email);
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("-----Your status is ----");
				System.out.println(resultSet.getString(7)+" "+l);	
			}
		}	
		else {
			System.out.println("---------------Go get a life--------------------");
		}
		connection.close();
	}
}
