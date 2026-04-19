import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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

            out.println("<html><body style='background:magenta; text-align:center;'>");

            if (i > 0) {
                out.println("<h2 style='color:green;'>Registration Successful</h2>");
            } else {
                out.println("<h2 style='color:red;'>Registration Failed</h2>");
            }

            out.println("<a href='Reg.html'>Back</a>");
            out.println("</body></html>");

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h2 style='color:red;'>Error: " + e + "</h2>");
        }
    }
}
