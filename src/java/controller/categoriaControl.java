
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import entidade.Categoria;
import model.categoriaDao;


@WebServlet(name = "categoriaControl", urlPatterns = {"/categoriaControl"})
public class categoriaControl extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        categoriaDao categoriaDAO = new categoriaDao();
        ArrayList<Categoria> categorias;
        Categoria categoria = new Categoria();
        int categoriaId;
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inicial":
                categorias = categoriaDAO.listaCategorias();
                request.setAttribute("categorias", categorias);
                RequestDispatcher listar = getServletContext().getRequestDispatcher("/categoria.jsp");
                listar.forward(request, response);
                
                break;
            case "inserir":
                categoria.setId(0);
                categoria.setDescricao("");
                
                request.setAttribute("categoria", categoria);
                RequestDispatcher insert = getServletContext().getRequestDispatcher("/insere-categoria.jsp");
                insert.forward(request, response);
                
                break;
            case "alterar":
                categoriaId = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaDAO.buscaCategorias(categoriaId);
                
                request.setAttribute("categoria", categoria);
                RequestDispatcher update = getServletContext().getRequestDispatcher("/altera-categoria.jsp");
                update.forward(request, response);
                
                break;
            case "deletar":
                categoriaId = Integer.parseInt(request.getParameter("id"));
                categoriaDAO.deletarCategoria(categoriaId);
                
                categorias = categoriaDAO.listaCategorias();
                
                request.setAttribute("categorias", categorias);
                RequestDispatcher delete = getServletContext().getRequestDispatcher("/categoria.jsp");
                delete.forward(request, response);
                
                break;
        }       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        categoriaDao categoriaDAO = new categoriaDao();
        request.setCharacterEncoding("UTF-8");
        String message = "";
        
        try {
            Categoria categoria = new Categoria();
            if (request.getParameter("descricao").equals("")) {
                message = "Descricao vazia";
                request.setAttribute("error", 1);
            }
            
            if (message.equals("")) {
                categoria.setId(Integer.parseInt(request.getParameter("id")));
                categoria.setDescricao(request.getParameter("descricao"));

                if (categoria.getId() == 0) {
                    if (categoriaDAO.inserirCategoria(categoria)) {
                        message = "Categoria adicionada!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Erro!";
                        request.setAttribute("error", 1);
                    }
                } else {
                    if (categoriaDAO.alterarCategoria(categoria)) {
                        message = "Categoria alterada!";
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
            ArrayList<Categoria> categorias;
            categorias = categoriaDAO.listaCategorias();
            request.setAttribute("categorias", categorias);
            RequestDispatcher listar = getServletContext().getRequestDispatcher("/categoria.jsp");
            listar.forward(request, response);
        }
    }
}