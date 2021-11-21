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
       
        
        <div>
            <form style="max-width:480px;margin:auto;" name="login" onsubmit="tchamou()">
                <div class="mb-2">

                    <input type="text" id="cpf" class="cpf form-control" placeholder="CPF">
                    <input type="password" id="senha" class="form-control" placeholder="SENHA">
                    <div class="form-check">
                        <input class="form-check-input opcao" type="radio" name="opcao" id="admRadio">
                        <label class="form-check-label" for="admRadio">Administrador</label>
                     </div>
                    <div class="form-check">
                        <input class="form-check-input opcao" type="radio" name="opcao" id="userRadio">
                        <label class="form-check-label" for="userRadio">Usuario</label>
                    </div>
                </div>
                
                <button onclick="verificaCheck()"> Enviar </button>
                <button onclick="location.href = 'http://www.google.com';" > Enviar </button>
            </form>
        </div>
        
        <script type="text/javascript">
            
           function funcionou(){
               alert("vasco");
           }            
            function verificaCheck(){
                
               var checkedValue = null; 
                var inputElements = document.getElementsByClassName('opcao');
                for(var i=0; inputElements[i]; ++i){
                      if(inputElements[i].checked){
                           checkedValue = inputElements[i].id;
                           if(checkedValue === "admRadio"){
                               //location.replace("admin.html");
                               alert("passou aqui");
                               //window.location.replace("http://www.w3schools.com");
                               //window.location.replace("http://www.google.com");
                               window.location.replace("admin.html");
                               alert("aqui tbm");
                           }
                           break;
                }
}
            }
                
        </script>
        
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
