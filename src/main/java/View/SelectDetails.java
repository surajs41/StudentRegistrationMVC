package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Controller.SelectData;
import Model.Student;

@WebServlet("/SelectDetails")
public class SelectDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Student List</title>");
		out.println("<style>");
		out.println("table {");
		out.println("  width: 100%;");
		out.println("  border-collapse: collapse;");
		out.println("}");
		out.println("table th, table td {");
		out.println("  border: 1px solid #ddd;");
		out.println("  padding: 10px;");
		out.println("  text-align: left;");
		out.println("}");
		out.println("table th {");
		out.println("  background-color: #4CAF50;");
		out.println("  color: white;");
		out.println("}");
		out.println("table tr:nth-child(even) {");
		out.println("  background-color: #f2f2f2;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href='index.html'>Add New Student</a>");
		out.println("<h1>Student List</h1>");
		List<Student> list = SelectData.getAllStudents();
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Password</th>");
		out.println("<th>Email</th>");
		out.println("<th>Address</th>");
		out.println("<th>City</th>");
		out.println("<th>Country</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for (Student s : list) {
			out.println("<tr>");
			out.println("<td>" + s.getId() + "</td>");
			out.println("<td>" + s.getName() + "</td>");
			out.println("<td>" + s.getPassword() + "</td>");
			out.println("<td>" + s.getEmail() + "</td>");
			out.println("<td>" + s.getAddress() + "</td>");
			out.println("<td>" + s.getCity() + "</td>");
			out.println("<td>" + s.getCountry() + "</td>");
			out.println("<td><a href='UpdateDetails?id=" + s.getId() + "'>Edit</a></td>");
			out.println("<td><a href='DeleteDetails?id=" + s.getId() + "'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
