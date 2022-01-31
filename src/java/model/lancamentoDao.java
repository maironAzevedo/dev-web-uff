/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import connection.connectionFactory;
import entidade.Lancamento;

/**
 *
 * @author mairo
 */
@WebServlet(name = "lancamentoDao", urlPatterns = {"/lancamentoDao"})
public class lancamentoDao extends HttpServlet {
    
    private Connection conexao;
    
    public lancamentoDao() {
        try {
            conexao = connectionFactory.newConnection();
        } catch(SQLException e) {
            System.out.println("Falha na conexão");
        }
    }
    
    public ArrayList<Lancamento> listaLancamentos(int idConta) {
        ArrayList<Lancamento> resultado = new ArrayList<>();
        try {            
            
            String sql = "SELECT * FROM lancamentos WHERE id_conta = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idConta);
            
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                Lancamento lancamento = new Lancamento();
                
                lancamento.setId(rs.getInt("id"));
                lancamento.setId_conta( rs.getInt("id_conta"));
                lancamento.setId_categoria(rs.getInt("id_categoria"));
                lancamento.setValor(rs.getFloat("valor"));
                lancamento.setOperacao(rs.getString("operacao"));
                lancamento.setData(rs.getString("data"));
                lancamento.setData(rs.getString("descricao"));
  
                resultado.add(lancamento);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public boolean inserirLancamento (Lancamento lancamento) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO lancamentos (id_conta, id_categoria, valor, operacao, data, descricao) VALUES (?,?,?,?,?,?)");
            
            preparedStatement.setInt(1, lancamento.getId_conta());
            preparedStatement.setInt(2, lancamento.getId_categoria());
            preparedStatement.setDouble(3, lancamento.getValor());
            preparedStatement.setString(4, lancamento.getOperacao());
            preparedStatement.setString(5, lancamento.getData());
            preparedStatement.setString(6, lancamento.getDescricao());
            preparedStatement.executeUpdate();
            
            return true;
            
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
}
