package Controller;

import java.util.*;
import java.sql.*;

import Model.Student;

public class SelectData
{
  public static Student getStudentsById(int id)
  {
	  Student s= new Student();
	  try
	  {
		 Connection con=ConnectionData.getConnection();
		 PreparedStatement pst=con.prepareStatement("Select * from student Where id=?");
		 pst.setInt(1, id);
		 ResultSet rs=pst.executeQuery();
		 if(rs.next())
		 {
			s.setId(rs.getInt(1)); 
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setPassword(rs.getString(5));
			s.setCountry(rs.getString(6));
			s.setAddress(rs.getString(7));
		 }
		 con.close();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  return s;
  }
  public static List<Student>getAllStudents()
  {
	  List<Student>list=new ArrayList<Student>();
	  try
	  {
		  Connection con=ConnectionData.getConnection();
		  PreparedStatement pst=con.prepareStatement("select * from student");
		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		  {
			  Student s=new Student();
			  s.setId(rs.getInt(1));
			  s.setName(rs.getString(2));
			  s.setPassword(rs.getString(3));
			  s.setEmail(rs.getString(4));
			  s.setAddress(rs.getString(5));
			  s.setCity(rs.getString(6));
			  s.setCountry(rs.getString(7));
			  list.add(s);
			  }
		  con.close();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  return list;
  }
}
