
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class Login extends HttpServlet {
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String mail = request.getParameter("name");
        String pass = request.getParameter("pass");
        
        
      EmailSend obj=new EmailSend();
     boolean x= obj.Mail(mail);
     
     if(x==false) {
     
    	 out.println("<p>invalid mail id</p>");
 
     }
     else {
    	 out.println("<p>your logged in successfully check ur mail</p>");
    	 
     }
    }  
}