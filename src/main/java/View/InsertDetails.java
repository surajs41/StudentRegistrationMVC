package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Controller.InsertData;
import Model.Student;
@WebServlet("/InsertDetails")
public class InsertDetails extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name,password,email,city,country,address;
		name=request.getParameter("name");
		password=request.getParameter("password");
		email=request.getParameter("email");
		city=request.getParameter("city");
		country=request.getParameter("country");
		address=request.getParameter("address");
		Student s=new Student();
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setCity(city);
		s.setCountry(country);
		s.setAddress(address);
		int status=InsertData.save(s);
		if(status>0)
		{
			pw.println("<h3>Record saved Successfully......</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			pw.println("<h3>Record Failed to Insert....</h3>");
		}
		pw.close();
		
	}

}