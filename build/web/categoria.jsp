<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Categoria</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templates/css/bootstrap.min.css">
        <link rel="icon" href="uff.jpg">
    </head>
    <body>
        
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./logged-page.jsp">Home</a>
        </nav>
        </header>
        
        <form onsubmit="cadastrou()">
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login" onsubmit="console.log('teste')">
                <div class="mb-2">
                    <div>
                        <label for="categoria" class="col-form-label">Categoria</label>
                        <input type="text" id="categoria" class="categoria form-control " placeholder="Digite a categoria">
                    </div>
                    
                    <button class="card mt-3 btn" style="min-width: 100px; margin: auto;">Cadastrar</button>
                </div>
            </fieldset>
        </form>
        
        
        <script>            
            function cadastrou(){
                alert("Categoria cadastrada com sucesso!");
            }
	</script>
    </body>
</html>
