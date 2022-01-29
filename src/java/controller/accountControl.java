package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.ContaCorrente;
import model.contacorrenteDao;
        
@WebServlet(name = "accountControl", urlPatterns = {"/accountControl"})
public class accountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        contacorrenteDao contacorrenteDao = new contacorrenteDao();
        ArrayList<ContaCorrente> contascorrentes;
        ContaCorrente contacorrente = new ContaCorrente();
        int contaCorrenteId;
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inserir":
                contacorrente.setId(0);
                contacorrente.setUserId(0);
                contacorrente.setNome("");
                contacorrente.setConta(0);
                contacorrente.setBanco("");
                contacorrente.setAgencia("");
                
                request.setAttribute("contacorrente", contacorrente);
                RequestDispatcher inserir = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                inserir.forward(request, response);
                
                break;
        }       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        contacorrenteDao contacorrenteDao = new contacorrenteDao();
        request.setCharacterEncoding("UTF-8");
        String message = "";
        
        try {
            ContaCorrente contacorrente = new ContaCorrente();
            if (request.getParameter("nome").equals("")) {
                message = "Nome vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("banco").equals("")) {
                message = "Banco vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("agencia").equals("")) {
                message = "Agencia vazia";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("conta").equals("")) {
                message = "Conta vazia";
                request.setAttribute("error", 1);
            }  
        } catch(NumberFormatException e) {
            message = "Error: " + e.getMessage();
            System.out.println(message);
            
            request.setAttribute("message", message);
            request.setAttribute("error", 1);
            
        } finally {
            ArrayList<ContaCorrente> contascorrentes;
            contascorrentes = contacorrenteDao.listaContas();
            
            request.setAttribute("contascorrentes", contascorrentes);
            RequestDispatcher list = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
            list.forward(request, response);
        }
    }
}
