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
<%String w_data = (String)request.getAttribute("w_data");
 out.print(w_data);
 %>
 <form action="homebutton" method="post"><br><br><input
    type="submit" value = "home" />
  </form>

 </html>