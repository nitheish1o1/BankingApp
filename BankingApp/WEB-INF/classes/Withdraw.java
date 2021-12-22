import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
public class Withdraw extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
  
        response.setContentType("text/html");  

        PrintWriter out = response.getWriter();
        int withdraw_amount = Integer.parseInt(request.getParameter("withdraw_amount"));

        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("userid");
        try{
            String url = "jdbc:mysql://localhost:3306/users";
            String sqlname = "root";
            String sqlpass = "password";
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(url,sqlname,sqlpass); 
            PreparedStatement ps;
            Statement stmt = con.createStatement();
            String sql1 = ("SELECT  balance " + "FROM userreg" + " WHERE name = '"+name+"'");
            ResultSet rs = stmt.executeQuery(sql1);
            int acc_balance = 0;
            String wdetail;
            while(rs.next()){
                acc_balance =  rs.getInt("balance");
            }
            if(withdraw_amount <= acc_balance){
                int final_amount = acc_balance-withdraw_amount;
                ps=con.prepareStatement("update userreg set balance = ? where name = ?");
                ps.setInt(1, final_amount );
                ps.setString(2,name); 
                ps.executeUpdate();
                ps = con.prepareStatement("insert into "+ name + " (txdate,txtype,txamount)"+"values(current_timestamp(),'withdraw',?)"); 
                ps.setInt(1, withdraw_amount);
                ps.executeUpdate();
                wdetail = ("Rs:"+withdraw_amount+" withdrawn successfullya:)\nyour acc balance is Rs:"+final_amount);

            }
            else{
                wdetail = ("insufficent funds");
            }
            request.setAttribute("w_data",wdetail);
            request.getRequestDispatcher("withdraw.jsp").forward(request,response);
        }catch (Exception e2) {out.println(e2);}
    }
}        