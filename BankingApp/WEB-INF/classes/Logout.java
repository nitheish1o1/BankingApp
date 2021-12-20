import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
public class Logout extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
     
    HttpSession session = request.getSession();
    session.invalidate();
    request.getRequestDispatcher("index.html").forward(request,response);


}
} 
