package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "Conexao", urlPatterns = {"/Conexao"})
public class connectionFactory extends HttpServlet {
    private static Connection conexao = null;
    public static Connection newConnection() throws SQLException {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/financeiro", "root", "");        
            } catch(ClassNotFoundException e) {
                System.out.println("Driver not found");
            }
        }
        return conexao;
    }

}
