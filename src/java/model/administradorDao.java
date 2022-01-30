
package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.Administrador;

@WebServlet(name = "administradorDao", urlPatterns = {"/administradorDao"})
public class administradorDao extends HttpServlet {

    
    private Connection conexao;

    public administradorDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("Falha na conexão");
        }
    }
    
    public ArrayList<Administrador> listaAdmins() {
        ArrayList<Administrador> arrayList = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM administradores");
            
            while (res.next()) {
                Administrador administrador = new Administrador();
                administrador.setId(res.getInt("id"));
                administrador.setNome(res.getString("nome"));
                administrador.setCpf(res.getString("cpf"));
                administrador.setSenha(res.getString("senha"));
                arrayList.add(administrador);
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return arrayList;
    }
    
    public Administrador buscaAdmin(int id) {
        Administrador administrador = new Administrador();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM administradores WHERE id = " + String.valueOf(id));
            
            if (res.next()) {
                administrador.setId(res.getInt("id"));
                administrador.setNome(res.getString("nome"));
                administrador.setCpf(res.getString("cpf"));
                administrador.setSenha(res.getString("senha"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return administrador;
    }
    
    public Administrador buscaAdmin(String cpf) {
        Administrador administrador = new Administrador();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM administradores WHERE cpf = '" + cpf + "'");
            
            if (res.next()) {
                administrador.setId(res.getInt("id"));
                administrador.setNome(res.getString("nome"));
                administrador.setCpf(res.getString("cpf"));
                administrador.setSenha(res.getString("senha"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return administrador;
    }
    
    public boolean inserirAdmin(Administrador administrador) {
        try {
            
            try {
                if (buscaAdmin(administrador.getCpf()).getCpf() != null) {
                    System.out.println("SQL Error: Invalid CPF");
                    return false;
                }
            } catch (NullPointerException npe) {
                System.out.println("CPF Not Found");
            }
            
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO "
                + " administradores (cpf, senha, nome) VALUES (?,?,?)");
            
            ps.setString(1, administrador.getCpf());
            ps.setString(2, administrador.getSenha());
            ps.setString(3, administrador.getNome());
            ps.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean alterarAdmin(Administrador administrador) {
        
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE administradores SET cpf=?, senha=?, nome=? WHERE id=?");
            
            ps.setString(1, administrador.getCpf());
            ps.setString(2, administrador.getSenha());
            ps.setString(3, administrador.getNome());
            ps.setInt(4, administrador.getId());
            ps.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletarAdmin(int id) {
        
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM administradores WHERE id = " + String.valueOf(id));
            ps.executeUpdate();

            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public Administrador login(String cpf, String senha) {
        Administrador administrador = new Administrador();
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM administradores WHERE cpf = ? AND senha = ?");
            sql.setString(1, cpf);
            sql.setString(2, senha);
            ResultSet resultSet = sql.executeQuery();
            
            if (resultSet.next()) {
                administrador.setId(resultSet.getInt("id"));
                administrador.setNome(resultSet.getString("nome"));
                administrador.setCpf(resultSet.getString("cpf"));
                administrador.setSenha(resultSet.getString("senha"));
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return null;
        }
        return administrador;
    }
}
