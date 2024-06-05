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
@WebServlet("/addTranslationServlet")
public class addTranslationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int wordId = Integer.parseInt(request.getParameter("wordId"));
        int languageId = Integer.parseInt(request.getParameter("languageId"));
        String translation = request.getParameter("translation");

        // Підключення до бази даних
        String jdbcUrl = "jdbc:sqlite:dictionary.db";
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "INSERT INTO translations (word_id, language_id, translation) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, wordId);
            pstmt.setInt(2, languageId);
            pstmt.setString(3, translation);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin.jsp");
    }
}

