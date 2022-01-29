<!DOCTYPE html>
<html>
    <head>
        <title>Projeto DevWeb - Primeira entrega</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <div class="card mb-4 row mt-4 text-center" style="margin: auto; padding: .8rem; max-width: 560px;">
            <img class="card-img-top col-sm-6" style="margin: auto" src="uff-card.png" alt="Logo UFF" min-width="40" min-height="80">
		
            <div class="card-body">
                <h1 class="card-title" style="font-size: 1.8rem">Aplicação DevWeb</h1>
                <p class="card-text" style="text-align: justify; color: #333;">A aplicação tem o seguinte objetivo de: apresentar um projeto funcional de um programa que simula a funcionalidade de um organizador financeiro digital, incluindo uma área pública, uma área privada e uma área de administração utilizando servlet + jsp para a construção da mesma</p>
            </div>
	    </div>
       
        <form method="POST" action="LoginControl">
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login" onsubmit="console.log('teste')">
                <div class="mb-1">
                    <div>
                        <label for="cpf" class="col-form-label">CPF</label>
                        <input type="text" id="cpf" name="cpf" class="cpf form-control " placeholder="Digite seu CPF">
                    </div>
                    
                    <div>
                        <label for="senha" class="col-form-label">Senha</label>
                        <input type="password" id="senha" name="senha" class="form-control " placeholder="Digite sua senha">     
                    </div>
                    <div class="mt-3">
                        <label>Acesso:</label>
                        
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio" name="acesso" id="admin" value="0">
                            <label class="form-check-label" for="administrador"> Administrador </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acesso" id="user" value="1" checked>
                            <label class="form-check-label" for="usuario"> Usuário </label>
                        </div>
                    </div>
                </div>
                
               <button type="submit" class="btn"><i class="fas fa-login"></i> Entrar </button>
            </fieldset>
        </form>
        
        <footer class="mastfoot mt-auto">
                <div class="mt-4 text-center">
                    <span>Desenvolverdores: Mairon Azevedo e Vitor Prado</span>
                </div>
        </footer>
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        <script src="templates/popper.min.js"></script>
        <script src="templates/js/bootstrap.min.js"></script>
    
        <script>
            $(document).ready(function() {
		        $('.cpf').mask('000.000.000-00', {reverse: true});
            });
	    </script>
    </body>
</html>
