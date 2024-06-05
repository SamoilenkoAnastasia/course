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


@WebServlet("/addWordServlet")
public class addWordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String word = request.getParameter("word");
        int languageId = Integer.parseInt(request.getParameter("languageId"));

        // Підключення до бази даних
        String jdbcUrl = DefaultData.DB_PATH;
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "INSERT INTO words (word, language_id) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, word);
            pstmt.setInt(2, languageId);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin.jsp");
    }
}

