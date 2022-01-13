
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidade.*;
import model.*;


@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "login":
                if (session.getAttribute("usuario") != null) {
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    session.setAttribute("usuario", usuario);
                    RequestDispatcher login = getServletContext().getRequestDispatcher("/loggedUser.jsp");
                    login.forward(request, response);
                } else if (session.getAttribute("administrador") != null) {
                    Administrador administrador = (Administrador) session.getAttribute("administrador");
                    session.setAttribute("administrador", administrador);
                    RequestDispatcher login = getServletContext().getRequestDispatcher("/loggedAdmin.jsp");
                    login.forward(request, response);
                }
                RequestDispatcher login = getServletContext().getRequestDispatcher("/index.jsp");
                login.forward(request, response);
                
                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    String message = "";
        
        try {
            usuarioDao usuarioDao = new usuarioDao();
            administradorDao administradorDAO = new administradorDao();
            
            if (request.getParameter("cpf").equals("")) {
                message = "'CPF' is empty or is invalid";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("senha").equals("")) {
                message = "'Senha' is empty";
                request.setAttribute("error", 1);
            }
            if (!(request.getParameter("acesso").equals("0") || request.getParameter("acesso").equals("1"))) {
                message = "'Tipo de Acesso' is empty";
                request.setAttribute("error", 1);
            }
            
            if (message.equals("")) {

                String cpf = request.getParameter("cpf");
                String senha = request.getParameter("senha");
                String acesso = request.getParameter("acesso");
                
                Usuario usuario = usuarioDao.logar(cpf, senha);
                Administrador administrador = administradorDAO.login(cpf, senha);
                
                if (usuario.getCpf() != null && acesso.equals("1")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    RequestDispatcher login = getServletContext().getRequestDispatcher("/loggedUser.jsp");
                    login.forward(request, response);
                } else if (administrador.getCpf() != null && acesso.equals("0")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("administrador", administrador);
                    RequestDispatcher login = getServletContext().getRequestDispatcher("/loggedAdmin.jsp");
                    login.forward(request, response);
                } else {
                    message = "Usuário/Administrador inválido";
                    request.setAttribute("error", 1);  
                    request.setAttribute("message", message);
                    RequestDispatcher loginFailed = getServletContext().getRequestDispatcher("/index.jsp");
                    loginFailed.forward(request, response);
                }
                
            }
            
        } catch(IOException | NumberFormatException | ServletException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
