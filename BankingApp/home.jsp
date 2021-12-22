<html>
    <%
    if(session.getAttribute("userid") ==null || session.getAttribute("passw") ==null ){
        response.sendRedirect("index.jsp");
    }

    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");

    response.setHeader("Pragme","no-cache,no-store,must-revalidate");

    response.setHeader("Expires","0");

    %>
<form action="displaybal" method="post"><br><br><input
    type="submit" value = "acc balance" />
  </form>

  <form action="bankstatement" method="post"><br><br><input
    type="submit" value = "statement" />
  </form>

  <form action="withdraw" method="post">
    Withdraw Amount :<input type="number" name="withdraw_amount" value = 0 min = "0" step = "100" /><br><br><input
    type="submit" value = "Withdraw" />
  </form>

  <form action="deposit" method="post">
    Deposit  Amount :<input type="number" name="deposit_amount" value = 0 min = "0" step = "100" /><br><br><input
    type="submit" value = "Deposit" />
  </form>
  
  <form action="logout" method="post"><br><br><input
    type="submit" value = "logout" />
  </form>

  </html>




