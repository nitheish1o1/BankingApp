import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Login extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

          
        String name=request.getParameter("userid");  
        String pass=request.getParameter("password"); 
        
        if(name == "" || pass == ""){
            out.print("<h3>userid/password should not be empty, please try again</h3>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        else{
          
        try{  
                String url = "jdbc:mysql://localhost:3306/users";
                String sqlname = "root";
                String sqlpass = "password";
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(url,sqlname,sqlpass);  
  
                PreparedStatement ps=con.prepareStatement("select * from userreg where name=? and pass=?");  
  
                ps.setString(1,name);  
                ps.setString(2,pass);   
          
                ResultSet rs = ps.executeQuery(); 
                HttpSession session = request.getSession();


 
                if(rs.next() == true) {
                    
                    session.setAttribute("userid", name);
                    session.setAttribute("passw",pass);
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                }  
                else{ 
                    out.print("<h3>Incorrect userid/pass</h3>");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                

                }
      
          
            }catch (Exception e2) {System.out.println(e2);}  
          
        out.close();  
    } } 
  
}  