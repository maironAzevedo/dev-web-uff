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
        
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
        </nav>
        </header>
        
        <form onsubmit="cadastrou()">
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login">
                <div class="mb-2">
                    <div>
                        <label for="nomeConta" class="col-form-label">Nome da Conta</label>
                        <input type="text" id="nomeConta" class="form-control " placeholder="Digite o nome da conta">
                    </div>
                    <div>
                        <label for="email" class="col-form-label">Banco</label>
                        <input type="text" id="banco" class="form-control " placeholder="Digite o banco">
                    </div>
                    <div>
                        <label for="agencia" class="col-form-label">Agência</label>
                        <input type="text" id="agencia" class="form-control " placeholder="Digite a agência">
                    </div>
                    <div>
                        <label for="contaCorrente" class="col-form-label">Conta corrente</label>
                        <input type="text" id="contaCorrente" class="form-control " placeholder="Digite a conta corrente">
                    </div>
                    
                </div>
                
                <div class="d-flex align-items-start mt-3 mb-3">
                    <a href="accountControl?action=inserir" class="btn btn-primary" style="margin: auto">
                        <i class="fas fa-plus"></i> Cadastrar
                    </a>
                </div>
            </fieldset>
        </form>        
    </body>
</html>
