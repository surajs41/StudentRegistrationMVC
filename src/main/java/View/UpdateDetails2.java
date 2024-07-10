package View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Controller.UpdateData;
import Model.Student;
@WebServlet("/UpdateDetails2")


public class UpdateDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		
		Student s= new Student();
		s.setId(id);
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setCity(city);
		s.setCountry(country);
		s.setAddress(address);
		int status=UpdateData.update(s);
		if(status>0)
		{
			response.sendRedirect("SelectDetails");
		}
		else 
		{
			out.println("unable to update");
		}
		out.close();
	}

}

	