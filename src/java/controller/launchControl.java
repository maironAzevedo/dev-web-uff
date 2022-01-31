/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidade.Categoria;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.Lancamento;
import model.categoriaDao;
import model.lancamentoDao;
/**
 *
 * @author mairo
 */
@WebServlet (name = "launchControl", urlPatterns = {"/launchControl"}) 
public class launchControl extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        categoriaDao categoriaDAO = new categoriaDao();
        ArrayList<Categoria> categorias;
        Categoria categoria = new Categoria();
        int categoriaId;
        categorias = categoriaDAO.listaCategorias();
        request.setAttribute("categorias", categorias);
        RequestDispatcher listar = getServletContext().getRequestDispatcher("/lancamento.jsp");
        listar.forward(request, response);
                
    }
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        
        try {
            Lancamento lancamento = new Lancamento();
            
            lancamento.setId_conta(Integer.parseInt(request.getParameter("id_conta")));
            lancamento.setId_categoria(Integer.parseInt(request.getParameter("id_categoria"))); 
            lancamento.setValor(Float.parseFloat(request.getParameter("valor")));          
            lancamento.setData(request.getParameter("data"));
            lancamento.setDescricao(request.getParameter("descricao"));
            lancamentoDao lancamentoDao = new lancamentoDao();
            
            if (request.getParameter("operacao").equals("Crédito")) {
                lancamento.setOperacao("C");
            } else {
                lancamento.setOperacao("D");
            }  
            
            if (lancamentoDao.inserirLancamento(lancamento)) {
                mensagem = "Lançamento gravado com sucesso";
                
            } else {
                mensagem = "Erro ao gravar lançamento!";
            }
            
            request.setAttribute("lancamento", lancamento);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loggedUser.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            mensagem = "Erro ao gravar lançamento!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loggedUser.jsp");
            rd.forward(request, response);
        }        
    }   
}
