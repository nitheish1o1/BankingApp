import java.io.*;  
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

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

            ArrayList <String> statementarray = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt(1);
                Timestamp timestamp = rs.getTimestamp(2);
                String type = rs.getString(3);
                int amount = rs.getInt(4);
                String data = (id+"------"+timestamp+"------"+type+"------"+amount);
                statementarray.add(data);

            }
            request.setAttribute("arr_data",statementarray);
            request.getRequestDispatcher("bankstatement.jsp").forward(request,response);
        }catch (Exception e2) {out.println(e2);}
    }
} 