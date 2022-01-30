<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de conta corrente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <%@page import="entidade.ContaCorrente"%>
        <%@page import="entidade.Usuario"%>
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
        </nav>
        </header>
        
        <%
          ContaCorrente conta = (ContaCorrente) request.getAttribute("conta");
        %>
        
        <div class="border mt-3 mb-3 m-3 col-sm-9">
            <form method="POST" action="accountControl?action=inicial">
                    <div class="form-group">
                        <label for="nomeConta" class="col-form-label"><b>Nome da Conta</b></label>
                        <input type="text" name="nomeConta" class="form-control " value="<%= conta.getNome() %>" placeholder="Digite o nome da conta">
                    </div>

                    <div class="form-group">
                        <label for="banco" class="col-form-label">Banco</label>
                        <input type="text" name="banco" class="form-control banco" value="<%=conta.getBanco()%>" placeholder="Digite o banco">
                    </div>

                    <div class="form-group">
                        <label for="agencia" class="col-form-label">Agência</label>
                        <input type="text" name="agencia" class="form-control agencia" value="<%=conta.getAgencia()%>" placeholder="Digite a agência">
                    </div>

                    <div class="form-group">
                        <label for="contaCorrente" class="col-form-label">Conta corrente</label>
                        <input type="text" name="contaCorrente" class="form-control conta-corrente" value="<%=conta.getConta()%>" placeholder="Digite a conta corrente">
                    </div>         

                    <button type="submit" class="btn" > Criar conta </button>

                    <input type="hidden" class="form-control" name="id" value="<%=conta.getId()%>">
            </form>
        </div>
                    
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        <script>
            $(document).ready(function() {
                $('.banco').mask('000', {reverse: true});
                $('.agencia').mask('00000', {reverse: true});
                $('.conta-corrente').mask('0000-0', {reverse: true});
            });
	</script>
    </body>
</html>
