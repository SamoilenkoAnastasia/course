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

@WebServlet("/deleteTranslationServlet")
public class deleteTranslationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int translationId = Integer.parseInt(request.getParameter("translationId"));

        // Підключення до бази даних
        String jdbcUrl = DefaultData.DB_PATH;
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "DELETE FROM translations WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, translationId);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin.jsp");
    }
}

