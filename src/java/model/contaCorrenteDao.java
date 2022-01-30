package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.ContaCorrente;

@WebServlet(name = "contacorrenteDao", urlPatterns = {"/contacorrenteDao"})
public class contaCorrenteDao extends HttpServlet {
    
    private Connection conexao;
    
    public contaCorrenteDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("Falha na conexão");
        }
    }
    
    public ArrayList<ContaCorrente> listaContas(int userId) {
        ArrayList<ContaCorrente> resultado = new ArrayList<>();
        try {            
            
            String sql = "SELECT * FROM contas WHERE id_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, userId);
            
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                ContaCorrente conta = new ContaCorrente();
                
                conta.setId(rs.getInt("id") );
                conta.setId_usuario( rs.getInt("id_usuario") );
                conta.setNome(rs.getString("nome_conta") );
                conta.setBanco(rs.getString("banco") );
                conta.setAgencia(rs.getString("agencia") );
                conta.setConta(rs.getString("conta_corrente") );
  
                resultado.add(conta);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public boolean inserirConta (ContaCorrente conta) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO contas (id_usuario, nome_conta, banco, agencia, conta_corrente) VALUES (?,?,?,?,?)");
            
            preparedStatement.setInt(1, conta.getId_usuario());
            preparedStatement.setString(2, conta.getNome());
            preparedStatement.setString(3, conta.getBanco());
            preparedStatement.setString(4, conta.getAgencia());
            preparedStatement.setString(5, conta.getConta());
            preparedStatement.executeUpdate();
            
            return true;
            
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
}
