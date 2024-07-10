package Controller;

import java.sql.*;
public class DeleteData {
     public static int delete(int id)
     {
    	 int status=0;
    	 try
    	 {
    		 Connection con=ConnectionData.getConnection();
 			PreparedStatement pst=con.prepareStatement("Delete from student  where id=?");
 			pst.setInt(1, id);
 			status=pst.executeUpdate();
 			con.close();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 return status;
     }
}