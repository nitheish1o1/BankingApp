import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;

public class Initialdepo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        
        int initialamount = Integer.parseInt(request.getParameter("initialamount"));
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("userid");

        try{
            String url = "jdbc:mysql://localhost:3306/users";
            String sqlname = "root";
            String sqlpass = "password";
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(url,sqlname,sqlpass);  
            PreparedStatement ps; 
            ps=con.prepareStatement("update userreg set balance = ? where name = ?");
            ps.setInt(1, initialamount);
            ps.setString(2,name); 
            ps.executeUpdate();

            Statement stmt = con.createStatement();
            String sql1 = "CREATE TABLE  "+name+
            "(txid INTEGER  AUTO_INCREMENT, " +
            " txdate timestamp, " + 
            " txtype VARCHAR(20), " + 
            " txamount INTEGER, " + 
            " PRIMARY KEY ( txid ))";
            stmt.executeUpdate(sql1);

            ps = con.prepareStatement("insert into "+ name + " (txdate,txtype,txamount)"+"values(current_timestamp(),'deposit',?)"); 
            ps.setInt(1, initialamount);
            ps.executeUpdate();
            request.getRequestDispatcher("home.jsp").forward(request,response);

        }catch (Exception e2) {out.println(e2);}

    }
}