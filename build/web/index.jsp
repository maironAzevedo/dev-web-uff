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
        <div class="card mb-5 row col-sm-3 mt-5 col-4 text-center" style="margin:auto;">
            <div><img class="card-img-top col-sm-6" src="uff-card.png" alt="Logo UFF" width="40" height="80"> </div>
		
		<div class="card-body">
			<p class="card-text">Primeira versão do sistema dos crias</p>
		</div>
	</div>
       
        
        <form>
            <fieldset style="max-width:480px;margin:auto;" name="login" onsubmit="tchamou()">
                <div class="mb-2">
                    <div>
                        <label for="cpf" class="display-1">CPF</label>
                        <input type="text" id="cpf" class="cpf form-control " placeholder="Digite seu CPF">
                    </div>
                    
                    <div>
                        <label for="senha" class="display-1">Senha</label>
                        <input type="password" id="senha" class="form-control " placeholder="Digite sua senha">     
                    </div>   
                </div>
                
                <button onclick="verificaCheck()"> Enviar </button>
            </fieldset>
        </form>
        
        <script>
            $(document).ready(function(){
		   $('.cpf').mask('000.000.000-00', {reverse: true});
		});
	</script>
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        <script src="templates/popper.min.js"></script>
        <script src="templates/js/bootstrap.min.js"></script>
        
    </body>
</html>
