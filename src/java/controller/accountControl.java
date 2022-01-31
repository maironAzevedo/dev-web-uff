package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidade.ContaCorrente;
import model.contaCorrenteDao;

@WebServlet(name = "accountControl", urlPatterns = {"/accountControl"})
public class accountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int userId;
        ArrayList<ContaCorrente> contas;
        HttpSession session = request.getSession();
        contaCorrenteDao contacorrenteDao = new contaCorrenteDao();
        ContaCorrente conta = new ContaCorrente();
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inicial":
                userId = (int) session.getAttribute("idUsuario");
                contas = contacorrenteDao.listaContas(userId);
                request.setAttribute("contas", contas);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/dashboardUser.jsp");
                mostrar.forward(request, response);
                break; 
            
            case "inserir":
                userId = (int) session.getAttribute("idUsuario");
                conta.setId(0);
                conta.setId_usuario(userId);
                conta.setNome("");
                conta.setBanco("");
                conta.setAgencia("");
                conta.setConta("");

                request.setAttribute("conta", conta);
                RequestDispatcher incluir = getServletContext().getRequestDispatcher("/formConta.jsp");
                incluir.forward(request, response);
                
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            ContaCorrente conta = new ContaCorrente();

            conta.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            conta.setNome(request.getParameter("nome_conta"));
            conta.setBanco(request.getParameter("banco"));
            conta.setAgencia(request.getParameter("agencia"));
            conta.setConta(request.getParameter("conta_corrente"));
            
            contaCorrenteDao contaDao = new contaCorrenteDao();

            if (contaDao.inserirConta(conta)) {
                mensagem = "Conta gravada com sucesso!";
            } else {
                mensagem = "Erro ao gravar conta!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loggedUser.jsp");
            rd.forward(request, response);

        } catch (IOException | NumberFormatException | ServletException e) {
            mensagem = "Erro ao gravar conta!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loggedUser.jsp");
            rd.forward(request, response);
        }
    }
}



