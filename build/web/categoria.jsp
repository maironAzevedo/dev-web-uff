<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Categoria"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Categoria</title>
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
                    <a href="categoriaControl?action=inserir" class="btn btn-primary"><i class="fas fa-plus"></i> Nova categoria </a>
        </div>
        
         <div class="table-responsive">
                <table class="table table-striped" >
                    <%
                        ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("Categoria");
                    %>
                    
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col"> Nome </th>
                            <th scope="col"> CPF </th>
                            <th scope="col"> A��es </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int index = 0; index < categorias.size(); index++) {
                                
                                Categoria categoria = categorias.get(index);
                                
                                String altera = "categoriaControl?action=alterar&id=" + categoria.getId();
                                String deleta = "categoriaControl?action=deletar&id=" + categoria.getId();
                        %>
                            <tr>
                                <td><%= categoria.getDescricao() %></td>
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

