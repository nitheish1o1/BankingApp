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

    <form action="homebutton" method="post"><br><br><input
        type="submit" value = "home" />
      </form>
    <h1>Bank statement</h1>
    <h3>id------timestamp------------type------amount</h3>
    <%
    ArrayList <String> statementarray = (ArrayList<String>)request.getAttribute("arr_data");
    for(String d:statementarray){
        out.print(d);
        out.print("<br/>");
    }
    %>
    <form action="homebutton" method="post"><br><br><input
        type="submit" value = "home" />
      </form>

</html>