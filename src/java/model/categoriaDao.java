
package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.Categoria;


@WebServlet(name = "categoriaDao", urlPatterns = {"/categoriaDao"})
public class categoriaDao extends HttpServlet {

    private Connection conexao;

    public categoriaDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("CategoriaDAO: connection failed");
        }
    }
    
    public ArrayList<Categoria> listaCategorias() {
        ArrayList<Categoria> arrayList = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM categorias");
            
            while (res.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(res.getInt("id"));
                categoria.setDescricao(res.getString("descricao"));
                arrayList.add(categoria);
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return arrayList;
    }
    
    public Categoria buscaCategorias(int id) {
        Categoria categoria = new Categoria();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM categorias WHERE id = " + String.valueOf(id));
            
            if (res.next()) {
                categoria.setId(res.getInt("id"));
                categoria.setDescricao(res.getString("descricao"));
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return categoria;
    }
    
    public boolean inserirCategoria(Categoria categoria) {
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO categorias " + 
               " (descricao) VALUES (?)");
            
            ps.setString(1, categoria.getDescricao());
            ps.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean alterarCategoria(Categoria categoria) {
        try {
            PreparedStatement ps = conexao.prepareStatement("UPDATE categorias SET descricao=? WHERE id=?");
            
            ps.setString(1, categoria.getDescricao());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();
            
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletarCategoria(int id) {
        try {
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM categorias WHERE id = " + String.valueOf(id));
            ps.executeUpdate();

            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
}
