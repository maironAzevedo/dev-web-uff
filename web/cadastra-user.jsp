<%@page import="entidade.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Administrador"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedAdmin.jsp">Home</a>
        </nav>
        </header>
        
        <div class="table-responsive">
            <table class="table table-striped" >
                <%
                    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
                %>

                <thead class="thead-dark">
                    <tr>
                        <th scope="col"> Nome </th>
                        <th scope="col"> CPF </th>
                        <th scope="col"> Suspenso </th>
                        <th scope="col"> Ações </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int index = 0; index < usuarios.size(); index++) {

                            Usuario usuario = usuarios.get(index);

                            String altera = "userControl?action=alterar&id=" + usuario.getId();
                            String deleta = "userControl?action=deletar&id=" + usuario.getId();
                    %>
                        <tr>
                            <td><%= usuario.getNome() %></td>
                            <td class="cpf"><%= usuario.getCpf() %></td>
                            <td><%= usuario.getSuspenso()%></td>
                            <td class="d-flex flex-row">
                                <a href="<%= altera %>" class="btn m-1"></i>Alterar</a>
                                <a href="<%= deleta %>" class="btn m-1"></i>Deletar</a>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        <div class="d-flex align-items-start mt-3 mb-3">
            <a href="userControl?action=inserir" class="btn btn-primary" style="margin: auto">
                <i class="fas fa-plus"></i> Novo Usuário 
            </a>
        </div>
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        
        
    </body>
</html>
