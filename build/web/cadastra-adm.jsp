<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Administrador"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Administrador</title>
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
        
        <div class="d-flex align-items-start mt-3 mb-3">
            <a href="adminControl?action=inserir" class="btn btn-primary"><i class="fas fa-plus"></i> Novo Usuário </a>
        </div>
        
         <div class="table-responsive">
                <table class="table table-striped" >
                    <%
                        ArrayList<Administrador> admins = (ArrayList<Administrador>) request.getAttribute("Administrador");
                    %>
                    
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col"> Nome </th>
                            <th scope="col"> CPF </th>
                            <th scope="col"> Ações </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int index = 0; index < admins.size(); index++) {
                                
                                Administrador admin = admins.get(index);
                                
                                String altera = "adminControl?action=alterar&id=" + admin.getId();
                                String deleta = "adminControl?action=deletar&id=" + admin.getId();
                        %>
                            <tr>
                                <td><%= admin.getNome() %></td>
                                <td class="cpf"><%= admin.getCpf() %></td>
                                <td class="d-flex flex-row justify-content-center align-items-center p-2">
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
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        
        <script>
            $(document).ready(function() {
		        $('.cpf').mask('000.000.000-00', {reverse: true});
            });
	</script>
        
        
    </body>
</html>
