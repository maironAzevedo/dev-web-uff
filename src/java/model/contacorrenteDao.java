package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.ContaCorrente;

@WebServlet(name = "contacorrenteDao", urlPatterns = {"/contacorrenteDao"})
public class contacorrenteDao extends HttpServlet {
   
    private Connection conexao;

    public contacorrenteDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("Falha na conexão");
        }
    }
    
    public ArrayList<ContaCorrente> listaContas() {
        ArrayList<ContaCorrente> arrayList = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM contas");
            
            while (res.next()) {
                ContaCorrente contacorrente = new ContaCorrente();
                contacorrente.setId(res.getInt("id"));
                contacorrente.setUserId(res.getInt("id_usuario"));
                contacorrente.setConta(res.getInt("conta_corrente"));
                contacorrente.setNome(res.getString("nome_conta"));
                contacorrente.setBanco(res.getString("banco"));
                contacorrente.setAgencia(res.getString("agencia"));
                arrayList.add(contacorrente);
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return arrayList;
    }
    
    public ContaCorrente buscaContaCorrente ( int conta ) {
        ContaCorrente contacorrente = new ContaCorrente();
        try {
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE cpf = '" + conta + "'");
            
            if (resultSet.next()) {
                contacorrente.setId(resultSet.getInt("id"));
                contacorrente.setUserId(resultSet.getInt("id_usuario"));
                contacorrente.setConta(resultSet.getInt("conta_corrente"));
                contacorrente.setNome(resultSet.getString("nome_conta"));
                contacorrente.setBanco(resultSet.getString("banco"));
                contacorrente.setAgencia(resultSet.getString("agencia"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return contacorrente;
    }
    
    public boolean inserirConta(ContaCorrente contacorrente) {
        try {          
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO contas"
                    + "  (id, id_usuario, nome_conta, banco, agencia, conta_corrente) VALUES (?,?,?,?,?,?)");
            
            preparedStatement.setInt(1, contacorrente.getId());
            preparedStatement.setInt(2, contacorrente.getUserId());
            preparedStatement.setString(3, contacorrente.getNome());
            preparedStatement.setString(4, contacorrente.getBanco());
            preparedStatement.setString(5, contacorrente.getAgencia());
            preparedStatement.setInt(6, contacorrente.getConta());
            preparedStatement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
}
