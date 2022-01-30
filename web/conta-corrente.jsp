<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
        </nav>
        </header>
        
        <%ContaCorrente contacorrente = (ContaCorrente) request.getAttribute("contacorrente");%>
        
        <form method="POST" onsubmit="accountControl?action=inicial">
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login">
                <div class="mb-2">
                    <div>
                        <label for="nomeConta" class="col-form-label">Nome da Conta</label>
                        <input type="text" name="nomeConta" class="form-control " value="<%= contacorrente.getNome() %>" placeholder="Digite o nome da conta">
                    </div>
                    <div>
                        <label for="banco" class="col-form-label">Banco</label>
                        <input type="number" name="banco" class="form-control " value="<%= contacorrente.getBanco() %>" placeholder="Digite o banco">
                    </div>
                    <div>
                        <label for="agencia" class="col-form-label">Agência</label>
                        <input type="text" name="agencia" class="form-control " value="<%= contacorrente.getAgencia() %>" placeholder="Digite a agência">
                    </div>
                    <div>
                        <label for="contaCorrente" class="col-form-label">Conta corrente</label>
                        <input type="number" name="contaCorrente" class="form-control " value="<%= contacorrente.getConta() %>" placeholder="Digite a conta corrente">
                    </div>
                    
                </div>
                
                    <button type="submit" class="btn" > Criar conta </button>
                    
                    <input type="hidden" class="form-control" name="id" value="<%= contacorrente.getId() %>">
                    <input type="hidden" class="form-control" name="idUsuario" value="<%= contacorrente.getUserId() %>">
            </fieldset>
        </form>  
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        <script>
            $(document).ready(function() {
		        $('.agencia').mask('0000-0', {reverse: true});
            });
	</script>
    </body>
</html>
