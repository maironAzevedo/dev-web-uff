<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de conta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <%@page import="entidade.ContaCorrente"%>
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
            <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
                <a href="./loggedAdmin.jsp">Home</a>
            </nav>
        </header>
        
        <%
            ContaCorrente conta = new ContaCorrente();
        %>

        <div class="border mt-3 mb-3 m-3 col-sm-9">
            <form method="POST" action="accountControl">                   
              
                <div class="form-group">
                    <label for="nome_conta"><b>Nome da conta</b></label>
                    <input type="text" class="form-control" name="nome_conta"  value="<%= conta.getNome() %>" placeholder="Digite o Nome da conta" required>
                </div>

                <div class="form-group">
                    <label for="banco"><b>Banco</b></label>
                    <input type="text" class="form-control banco" name="banco" value="<%= conta.getBanco() %>" placeholder="Digite o banco" required>
                </div>

                <div class="form-group">
                    <label for="agencia"><b>Agencia</b></label>
                    <input type="text" class="form-control agencia" name="agencia" value="<%= conta.getAgencia() %>" placeholder="Digite a agencia" required>
                </div>
                
                <div class="form-group">
                    <label for="conta_corrente"><b>Conta</b></label>
                    <input type="text" class="form-control conta" name="conta_corrente" value="<%= conta.getConta() %>" placeholder="Digite a conta" required>
                </div>

                <button type="submit" class="btn"> Cadastrar Conta </button>
                
                 
                <input type="hidden" class="form-control" name="id" value="<%=conta.getId()%>">
                <input type="hidden" class="form-control" name="id_usuario" value="<%=session.getAttribute("usuario")%>">
            </form>
        </div>
                    
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        <script>
            $(document).ready(function() {
		$('.banco').mask('000', {reverse: true});
                $('.agencia').mask('00000', {reverse: true});
                $('.conta').mask('0000-0', {reverse: true});
            });
	</script>
                    
    </body>
</html>
