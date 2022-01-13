package connection;
import java.sql.Connection;
import java.sql.SQLException;


public class testaConexao {
   
    public static void main(String[] args) throws SQLException {
        System.out.println("Teste");
        Connection connection = new connectionFactory().newConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }    
}