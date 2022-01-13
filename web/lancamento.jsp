<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>LanÁamentos</title>
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
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login" onsubmit="console.log('teste')">
                <div class="mb-2">
                    <div>
                        <label for="valor" class="col-form-label">Valor</label>
                        <input type="text" id="valor" class="valor form-control " placeholder="Digite o valor">
                    </div>
                    <div>
                        <label for="date" class="col-form-label">Data</label>
                        <input type="text" id="date" class="date form-control " placeholder="Digite a data">
                    </div>
                    <div>
                        <label for="descricao" class="col-form-label">DescriÁ„o (opcional)</label>
                        <input type="text" id="descricao" class="form-control " placeholder="Digite a descriÁ„o">
                    </div>
                    <div class="mt-2">
                        <label for="cars">Categoria:</label>

                        <select name="categoria" id="categoria">
                          <option value="transferencia">TransferÍncia</option>
                          <option value="agua">¡Ågua</option>
                          <option value="luz">Luz</option>
                          <option value="planosaude">Plano de sa˙de</option>
                        </select>
                    </div>
                    <p>Tipo de operaÁ„o:</p>
                    <div>
                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="debito">
                        <label for="opcaoCategoria">CrÈdito</label>     

                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="credito">
                        <label for="opcaoCategoria">DÈbito</label>
                    </div>
                    
                    <button class="card mt-3 btn" style="min-width: 100px; margin: auto;">Confirmar</button>
                </div>
            </fieldset>
        </form>
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        
        <script>
            $(document).ready(function() {
		        
                        $('.date').mask('00/00/0000');
                        $('.valor').mask("#.##0,00", {reverse: true});
            });
            
            function cadastrou(){
                alert("Lan√ßamento feito com sucesso!");
            }
	</script>
        
        
        
    </body>
</html>
