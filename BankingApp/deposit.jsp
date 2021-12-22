<%@page import = "java.util.*"%>
<html>
    <%
    if(session.getAttribute("userid") ==null){
        response.sendRedirect("index.jsp");
    }

    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");

    response.setHeader("Pragme","no-cache,no-store,must-revalidate");

    response.setHeader("Expires","0");

    %>
<%String d_data = (String)request.getAttribute("d_data");
 out.print(d_data);
 %>
 <form action="homebutton" method="post"><br><br><input
    type="submit" value = "home" />
  </form>

 </html>