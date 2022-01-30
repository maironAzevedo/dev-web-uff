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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        try{
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");


            if(!cpf.isEmpty() && cpf.length() == 14 & !senha.isEmpty()){
                administradorDao administradorDao = new administradorDao();
                Administrador loginAdministrador = administradorDao.login(cpf, senha);

                usuarioDao usuarioDao = new usuarioDao();
                Usuario loginUsuario = usuarioDao.logar(cpf, senha);

                if(loginAdministrador != null){
                    Administrador administrador = new Administrador();

                    session.setAttribute("administrador", loginAdministrador.getId());

                    RequestDispatcher rd = request.getRequestDispatcher("/loggedAdmin.jsp");
                    rd.forward(request, response);
                } 
                else if(loginUsuario != null){
                    Usuario usuario = new Usuario();

                    session.setAttribute("usuario", loginUsuario.getId());

                    RequestDispatcher rd = request.getRequestDispatcher("/loggedUser.jsp");
                    rd.forward(request, response);
                }
                else {
                    session.setAttribute("erro", "sim");

                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
