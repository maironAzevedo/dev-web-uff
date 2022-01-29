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
}
