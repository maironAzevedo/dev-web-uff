<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de administrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <%@page import="entidade.Categoria"%>
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedAdmin.jsp">Home</a>
             <a href="categoriaControl?action=inicial">Cadastrar Categoria</a>
        </nav>
        </header>
        
        <%Categoria categoria = (Categoria) request.getAttribute("Categoria");%>

         <div class="border mt-3 mb-3 m-3 col-sm-9">
            <form method="POST" action="categoriaControl?action=inicial">                   

                <input type="hidden" class="form-control" name="id" id="id_nova_categoria" value="<%= categoria.getId() %>">


                <div class="form-group">
                    <label for="descricao"><b> Descrição </b></label>
                    <input type="text" class="form-control" name="descricao" value="<%= categoria.getDescricao()%>" placeholder="Digite a Descrição" required>
                </div>

                <button type="submit" class="btn"> Inserir </button>
            </form>
        </div>
                    
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
          
    </body>
</html>

