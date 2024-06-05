import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addLanguageServlet")
public class AddLanguageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String language = request.getParameter("language");

        // Підключення до бази даних
        String jdbcUrl = DefaultData.DB_PATH;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "INSERT INTO languages (name) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, language);
            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin.jsp");
    }
}
