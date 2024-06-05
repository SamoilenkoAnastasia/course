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
@WebServlet("/editWordServlet")
public class editWordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int wordId = Integer.parseInt(request.getParameter("wordId"));
        String word = request.getParameter("word");
        int languageId = Integer.parseInt(request.getParameter("languageId"));

        // Підключення до бази даних
        String jdbcUrl = DefaultData.DB_PATH;
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "UPDATE words SET word = ?, language_id = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, word);
            pstmt.setInt(2, languageId);
            pstmt.setInt(3, wordId);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin.jsp");
    }
}

