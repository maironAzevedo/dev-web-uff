package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.Usuario;
import model.usuarioDao;

@WebServlet(name = "userControl", urlPatterns = {"/userControl"})
public class userControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuarioDao usuarioDao = new usuarioDao();
        ArrayList<Usuario> usuarios;
        Usuario usuario = new Usuario();
        int usuarioId;
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inicial":
                usuarios = usuarioDao.listaUsuarios();
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher listar = getServletContext().getRequestDispatcher("/cadastra-user.jsp");
                listar.forward(request, response);
                
                break;
            case "inserir":
                usuario.setId(0);
                usuario.setNome("");
                usuario.setCpf("");
                usuario.setSenha("");
                usuario.setSuspenso("");
                
                request.setAttribute("usuario", usuario);
                RequestDispatcher inserir = getServletContext().getRequestDispatcher("/insere-user.jsp");
                inserir.forward(request, response);
                
                break;
            case "alterar":
                usuarioId = Integer.parseInt(request.getParameter("id"));
                usuario = usuarioDao.buscaUsuario(usuarioId);
                
                request.setAttribute("usuario", usuario);
                RequestDispatcher alterar = getServletContext().getRequestDispatcher("/altera-user.jsp");
                alterar.forward(request, response);
                
                break;
            case "deletar":
                usuarioId = Integer.parseInt(request.getParameter("id"));
                usuarioDao.deletarUsuario(usuarioId);
                
                usuarios = usuarioDao.listaUsuarios();
                
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher deletar = getServletContext().getRequestDispatcher("/cadastra-user.jsp");
                deletar.forward(request, response);
                
                break;
        }       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        usuarioDao usuarioDao = new usuarioDao();
        request.setCharacterEncoding("UTF-8");
        String message = "";
        
        try {
            Usuario usuario = new Usuario();
            if (request.getParameter("nome").equals("")) {
                message = "Nome vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("cpf").equals("")) {
                message = "CPF vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("senha").equals("")) {
                message = "Senha vazio";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("suspenso").equals("")) {
                message = "Suspenso vazio";
                request.setAttribute("error", 1);
            }
            
            if (message.equals("")) {
                usuario.setId(Integer.parseInt(request.getParameter("id")));
                usuario.setNome(request.getParameter("nome"));
                usuario.setCpf(request.getParameter("cpf"));
                usuario.setSenha(request.getParameter("senha"));
                usuario.setSuspenso(request.getParameter("suspenso"));

                if (usuario.getId() == 0) {
                    if (usuarioDao.inserirUsuario(usuario)) {
                        message = "Usuário cadastrado!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Erro!";
                        request.setAttribute("error", 1);
                    }
                } else {
                    if (usuarioDao.alterarUsuario(usuario)) {
                        message = "Usuário alterado!";
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
            ArrayList<Usuario> usuarios;
            usuarios = usuarioDao.listaUsuarios();
            
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher list = getServletContext().getRequestDispatcher("/cadastra-user.jsp");
            list.forward(request, response);
        }
    }
}