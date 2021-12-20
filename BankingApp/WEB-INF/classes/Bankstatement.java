import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;


public class Bankstatement extends HttpServlet {
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

            String sql1 = ("SELECT  * FROM "+name);

            ResultSet rs = stmt.executeQuery(sql1);

            out.println("id        timestamp       transaction        amount");
            out.println("<br/>");
            out.println("<br/>");
            while(rs.next()){
                int id = rs.getInt(1);
                Timestamp timestamp = rs.getTimestamp(2);
                String type = rs.getString(3);
                int amount = rs.getInt(4);
                out.println(id+"   "+timestamp+"   "+type+"   "+amount);
                out.println("<br/>");
            }
        }catch (Exception e2) {out.println(e2);}
    }
} 