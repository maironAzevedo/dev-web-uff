<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.usuarioDao"%>
<%@page import="entidade.ContaCorrente"%>
<%@page import="entidade.Usuario"%>

<html>
    <head>
        <title>Cadastro de conta corrente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
        </nav>
        </header>
        <%
            ContaCorrente conta = (ContaCorrente) request.getAttribute("conta");
            Usuario usuario = (Usuario) session.getAttribute("usuario");
        %>
        <form method="POST" action="accountControl"> 
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login">
                <div class="mb-2">
                    <input type="hidden" class="form-control" name="id" id="id" value="<%= conta.getId() %>">
                    <input type="hidden" class="form-control" name="id_usuario" id="id_usuario" value="<%= usuario.getId() %>">
                        
                <div class="form-group">
                    <label for="nomeConta"><b> Nome da conta</b></label>
                    <input type="text" class="form-control" name="nomeConta"  value="<%= conta.getNome() %>" placeholder="Digite o Nome da conta" required>
                </div>

                <div class="form-group">
                    <label for="banco"><b> Banco </b></label>
                    <input type="text" class="form-control" name="banco" value="<%= conta.getBanco() %>" placeholder="Digite o banco" required>
                </div>

                <div class="form-group">
                    <label for="agencia"><b> Agencia </b></label>
                    <input type="text" class="form-control" name="agencia" value="<%= conta.getAgencia() %>" placeholder="Digite a agencia" required>
                </div>
                
                 <div class="form-group">
                    <label for="contaCorrente"><b> Conta corrente </b></label>
                    <input type="text" class="form-control" name="contaCorrente" value="<%= conta.getConta() %>" placeholder="Digite a conta corrente" required>
                </div>
                    
                </div>
                
                <button type="submit" class="btn"> Inserir </button>
                </div>
            </fieldset>
        </form>        
    </body>
</html>
