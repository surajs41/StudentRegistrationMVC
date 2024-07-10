package Controller;

import java.sql.*;

import Model.Student;

public class InsertData
{
public static int save(Student s)
{
	int status=0;
	Connection con=ConnectionData.getConnection();
	String query="insert into student(name,password,email,city,country,address) values(?,?,?,?,?,?)";
	PreparedStatement pst;
	try
	{
		pst=con.prepareStatement(query);
		pst.setString(1,s.getName());
		pst.setString(2,s.getPassword());
		pst.setString(3,s.getEmail());
		pst.setString(4,s.getCity());
		pst.setString(5,s.getCountry());
		pst.setString(6,s.getAddress());
		status=pst.executeUpdate();
		con.close();
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	return status;
	}
}
