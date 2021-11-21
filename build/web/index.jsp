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
        <div class="card mb-5 row mt-5 text-center" style="margin: auto; padding: .8rem; max-width: 560px;">
            <img class="card-img-top col-sm-6" style="margin: auto" src="uff-card.png" alt="Logo UFF" min-width="40" min-height="80">
		
            <div class="card-body">
                <h1 class="card-title" style="font-size: 1.8rem">Aplica��o DevWeb - Primeira entrega</h1>
                <p class="card-text" style="text-align: justify; color: #333;">A aplica��o tem o seguinte objetivo de: apresentar um projeto funcional de um programa que simula a funcionalidade de um organizador financeiro digital, incluindo uma �rea p�blica, uma �rea privada e uma �rea de administra��o utilizando servlet + jsp para a constru��o da mesma</p>
            </div>
	    </div>
       
        <form>
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login" onsubmit="console.log('teste')">
                <div class="mb-2">
                    <div>
                        <label for="cpf" class="col-form-label">CPF</label>
                        <input type="text" id="cpf" class="cpf form-control " placeholder="Digite seu CPF">
                    </div>
                    
                    <div>
                        <label for="senha" class="col-form-label">Senha</label>
                        <input type="password" id="senha" class="form-control " placeholder="Digite sua senha">     
                    </div>   
                </div>
                
                <a class="card mt-3 btn" style="min-width: 100px; align-self: center;" href="./logged-page.jsp">
                    Enviar
                </a>
            </fieldset>
        </form>
        
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
