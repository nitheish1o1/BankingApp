import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;

public class Displaybal extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("userid");
        
        try{
            String url = "jdbc:mysql://localhost:3306/users";
            String sqlname = "root";
            String sqlpass = "password";
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(url,sqlname,sqlpass);  
            Statement stmt = con.createStatement();
            String sql1 = ("SELECT  balance " + "FROM userreg" + " WHERE name = '"+name+"'");
            ResultSet rs = stmt.executeQuery(sql1);
            String balance = "";
            while(rs.next()){
                balance = ("Account Balance: Rs:  " + rs.getInt("balance")+ "/-");
            }
            request.setAttribute("accbalance",balance);
            request.getRequestDispatcher("displaybalance.jsp").forward(request,response);
        }catch (Exception e2) {out.println(e2);}
    }
}        