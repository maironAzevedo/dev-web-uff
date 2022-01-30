
package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.Usuario;


@WebServlet(name = "usuarioDao", urlPatterns = {"/usuarioDao"})
public class usuarioDao extends HttpServlet {

    private Connection conexao;

    public usuarioDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("Falha na conexão");
        }
    }
    
    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> arrayList = new ArrayList<>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");
            
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setSuspenso(resultSet.getString("suspenso"));
                arrayList.add(usuario);
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return arrayList;
    }
    
    public Usuario buscaUsuario(int id) {
        Usuario usuario = new Usuario();
        try {
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE id = " + String.valueOf(id));
            
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setSuspenso(resultSet.getString("suspenso"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return usuario;
    }
    
    public Usuario buscaUsuario(String cpf) {
        Usuario usuario = new Usuario();
        try {
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE cpf = '" + cpf + "'");
            
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setSuspenso(resultSet.getString("suspenso"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return usuario;
    }
    
    public boolean inserirUsuario(Usuario usuario) {
        try {
            if (buscaUsuario(usuario.getCpf()).getCpf() != null) {
                System.out.println("SQL Error: Invalid CPF");
                return false;
            }
            
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO usuarios"
                    + "  (cpf, senha, nome, suspenso) VALUES (?,?,?,?)");
            
            preparedStatement.setString(1, usuario.getCpf());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(3, usuario.getNome());
            preparedStatement.setString(4, usuario.getSuspenso());
            preparedStatement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean alterarUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE usuarios"
                    + " SET cpf=?, senha=?, nome=?, suspenso=? WHERE id=?");
            
            preparedStatement.setString(1, usuario.getCpf());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(3, usuario.getNome());
            preparedStatement.setString(4, usuario.getSuspenso());
            preparedStatement.setInt(5, usuario.getId());
            preparedStatement.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletarUsuario(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM usuarios "
                    + "WHERE id = " + String.valueOf(id));
            preparedStatement.executeUpdate();

            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public Usuario logar(String cpf, String senha) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM usuarios WHERE cpf = ? AND senha = ?");
            sql.setString(1, cpf);
            sql.setString(2, senha);
            ResultSet resultSet = sql.executeQuery();
            
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setSuspenso(resultSet.getString("suspenso"));
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return null;
        }
        return usuario;
    }
}
