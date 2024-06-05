import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchWordServlet")
public class searchWordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int languageId = Integer.parseInt(request.getParameter("language"));
        String word = request.getParameter("word");

        // Підключення до бази даних
        String jdbcUrl = DefaultData.DB_PATH;
        List<String> translations = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT t.translation FROM words w " +
                    "INNER JOIN translations t ON w.id = t.word_id " +
                    "WHERE w.word = ? AND t.language_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, word);
            pstmt.setInt(2, languageId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String translation = rs.getString("translation");
                translations.add(translation);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("result", translations);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}

