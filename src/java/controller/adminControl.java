
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.Administrador;
import model.administradorDao;

@WebServlet(name = "adminControl", urlPatterns = {"/adminControl"})
public class adminControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        administradorDao adminDao = new administradorDao();
        ArrayList<Administrador> admins;
        Administrador admin = new Administrador();
        int adminId;
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inicial":
                admins = adminDao.listaAdmins();
                request.setAttribute("administradores", admins);
                RequestDispatcher listar = getServletContext().getRequestDispatcher("/cadastra-adm.jsp");
                listar.forward(request, response);
                
                break;
            case "inserir":
                admin.setId(0);
                admin.setNome("");
                admin.setCpf("");
                admin.setSenha("");
                
                request.setAttribute("administrador", admin);
                RequestDispatcher inserir = getServletContext().getRequestDispatcher("/insere-adm.jsp");
                inserir.forward(request, response);
                
                break;
            case "alterar":
                adminId = Integer.parseInt(request.getParameter("id"));
                admin = adminDao.buscaAdmin(adminId);
                
                request.setAttribute("administrador", admin);
                RequestDispatcher alterar = getServletContext().getRequestDispatcher("/altera-adm.jsp");
                alterar.forward(request, response);
                
                break;
            case "deletar":
                adminId = Integer.parseInt(request.getParameter("id"));
                adminDao.deletarAdmin(adminId);
                
                admins = adminDao.listaAdmins();
                
                request.setAttribute("administradores", admins);
                RequestDispatcher deletar = getServletContext().getRequestDispatcher("/cadastra-adm.jsp");
                deletar.forward(request, response);
                
                break;
        }       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        administradorDao adminDao = new administradorDao();
        request.setCharacterEncoding("UTF-8");
        String message = "";
        
        try {
            Administrador administrador = new Administrador();
            if (request.getParameter("nome").equals("")) {
                message = "Nome vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("cpf").equals("")) {
                message = "CPF vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("senha").equals("")) {
                message = "'Senha vazia";
                request.setAttribute("error", 1);
            }
            
            if (message.equals("")) {
                administrador.setId(Integer.parseInt(request.getParameter("id")));
                administrador.setNome(request.getParameter("nome"));
                administrador.setCpf(request.getParameter("cpf"));
                administrador.setSenha(request.getParameter("senha"));

                if (administrador.getId() == 0) {
                    if (adminDao.inserirAdmin(administrador)) {
                        message = "Novo Admin cadastrado!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Erro!";
                        request.setAttribute("error", 1);
                    }
                } else {
                    if (adminDao.alterarAdmin(administrador)) {
                        message = "Admin alterado!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Erro!";
                        request.setAttribute("error", 1);
                    }
                }
            }
            
            request.setAttribute("message", message);
            
        } catch(NumberFormatException e) {
            message = "Error: " + e.getMessage();
            System.out.println(message);
            
            request.setAttribute("message", message);
            request.setAttribute("error", 1);
            
        } finally {
            ArrayList<Administrador> administradores;
            administradores = adminDao.listaAdmins();
            
            request.setAttribute("administradores", administradores);
            RequestDispatcher list = getServletContext().getRequestDispatcher("/cadastra-adm.jsp");
            list.forward(request, response);
        }
    }
}