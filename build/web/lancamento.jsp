<!DOCTYPE html>
<html>
    <head>
        <title>Lançamentos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
            <a href="index.jsp">Sair</a>
        </nav>
        </header>
        
        <form>
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
                        <label for="descricao" class="col-form-label">Descrição (opcional)</label>
                        <input type="text" id="descricao" class="form-control " placeholder="Digite a descrição">
                    </div>
                    <div class="mt-2">
                        <label for="cars">Categoria:</label>

                        <select name="categoria" id="categoria">
                          <option value="transferencia">Transferência</option>
                          <option value="agua">Água</option>
                          <option value="luz">Luz</option>
                          <option value="planosaude">Plano de saúde</option>
                        </select>
                    </div>
                    <p>Tipo de operação:</p>
                    <div>
                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="debito">
                        <label for="opcaoCategoria">Crédito</label>     

                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="credito">
                        <label for="opcaoCategoria">Débito</label>
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
            
	</script> 
    </body>
</html>
