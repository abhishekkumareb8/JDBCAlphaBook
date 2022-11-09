package jdbc_eb8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCRUD {
	
	public void saveDetail(Employee employee) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee value(?,?,?)");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entre the number of deta you want to enter");
		int data= scanner.nextInt();
		
		for(int i=0;i<data;i++)
		{
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		
		preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		connection.close();
		System.out.println("Student details saved");
		
	}
	
	public void updateDeatail(int id, Employee employee) throws Exception
	{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set phone=? where id=?");
		preparedStatement.setLong(1, employee.getPhone());
		preparedStatement.setInt(2,id);
		
		preparedStatement.executeUpdate();
		connection.close();
		
		System.out.println("Details updated");
	}
	
	public void deleteDetail(int id) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=?");
		preparedStatement.setInt(1,id);
		
		preparedStatement.executeUpdate();
		connection.close();
	}
	
	public void readDetail() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		Statement statement = connection.createStatement();
		ResultSet resultset= statement.executeQuery("select * from employee");
		
		while(resultset.next())
		{
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong(3));
			System.out.println("================");
			
		}
		
		connection.close();
	}
	
	public void readById(int id) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","4NM15ec008@");
		
		PreparedStatement statement=connection.prepareStatement("select * from employee where id=?");		
		statement.setInt(1, id);
		ResultSet resultSet= statement.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));		
		}
		connection.close();
	}
	

}
