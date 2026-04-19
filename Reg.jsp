<%@ page language="java" import="java.sql.*" %>

<%
String name = request.getParameter("t1");
String pass = request.getParameter("t2");
String phone = request.getParameter("t3");
String email = request.getParameter("t4");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/db_24wh1a0592",
        "root",
        "1234"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO register VALUES (?, ?, ?, ?)"
    );

    ps.setString(1, name);
    ps.setString(2, pass);
    ps.setString(3, phone);
    ps.setString(4, email);

    int i = ps.executeUpdate();
%>

<h2 style="color:green;">
    <%= (i > 0) ? "Registration Successful" : "Registration Failed" %>
</h2>

<%
con.close();
} catch(Exception e) {
%>
<h2 style="color:red;">Error: <%= e %></h2>
<%
}
%>
