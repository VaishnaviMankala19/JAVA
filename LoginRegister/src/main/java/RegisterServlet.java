import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, email);
            st.setString(3, password);

            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("Login.jsp"); // Redirect to login page after successful registration
            } else {
                response.getWriter().print("Error: Registration failed.");
            }
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            e.printStackTrace(out);  // Print error directly in browser
        }
    }
}
