<!DOCTYPE html>
<html>
    <head>
        <title>Alteração de administrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <%@page import="entidade.Administrador"%>
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedAdmin.jsp">Home</a>
            <a href="./adminControl?action=inicial">Alterar Administrador</a>
            <a href="index.jsp">Sair</a>
        </nav>
        </header>
        
        <%Administrador admin = (Administrador) request.getAttribute("Administrador");%>

        <div class="border mt-3 mb-3 m-3 col-sm-9">
            <form method="POST" action="adminControl?action=inicial">                   

                <div class="form-group">
                    <label for="nome"><b> Nome </b></label>
                    <input type="text" class="form-control" name="nome"  value="<%= admin.getNome() %>" placeholder="Digite o Nome" required>
                </div>

                <div class="form-group">
                    <label for="cpf"><b> CPF </b></label>
                    <input type="text" class="form-control cpf" name="cpf" value="<%= admin.getCpf() %>" placeholder="Digite o CPF" required>
                </div>
                <div class="form-group">
                    <label for="senha"><b> Senha </b></label>
                    <input type="password" class="form-control" name="senha" value="<%= admin.getSenha() %>" placeholder="Digite a Senha" required>
                </div>

                <button type="submit" class="btn"> Editar </button>
                
                <input type="hidden" class="form-control" name="id" value="<%= admin.getId() %>">
            </form>
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

