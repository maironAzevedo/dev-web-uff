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
        <%@page import="entidade.Lancamento"%>
        <%@page import="java.util.ArrayList"%>
        <%@page import="entidade.Categoria"%>
        
        <header style="background-color: #f0f0f5; min-height: 40px; display: flex; align-items: center; justify-content: center;">
        <nav style="min-width: 1080px; display: flex; justify-content: space-evenly;">
            <a href="./loggedUser.jsp">Home</a>
            <a href="index.jsp">Sair</a>
        </nav>
        </header>
        
        <%
            Lancamento lancamento = new Lancamento();
            ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
        %>
        
        <form method="POST" action="launchControl">
            <fieldset style="max-width:480px; margin:auto; display: flex; flex-direction: column;" name="login" onsubmit="console.log('teste')">
                <div class="mb-2">
                    <div>
                        <label for="valor" class="col-form-label"><b>Identificador da Conta</b></label>
                        <input type="text" name="id_conta" class="form-control" placeholder="Digite o valor" value="<%= lancamento.getId_conta() %>">
                    </div>
                    
                    <div class="mt-2">
                        <label for="cars"><b>Categoria</b></label>
                        <select name="id_categoria" id="categoria" value="<%= lancamento.getId_categoria() %>">
                          <%
                            for (int index = 0; index < categorias.size(); index++) {
                                Categoria categoria = categorias.get(index);
                          %>
                                <option value="<%=categoria.getId()%>"><%=categoria.getDescricao()%></option>                          
                          <%
                            }
                          %>
                        </select>
                    </div>
                    
                    <div>
                        <label for="valor" class="col-form-label"><b>Valor</b></label>
                        <input type="text" name="valor" class="valor form-control " placeholder="Digite o valor" value="<%= lancamento.getValor() %>">
                    </div>
                    <br/>
                    <p><b>Tipo de Operação</b></p>
                    <div>
                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="debito" value="<%= lancamento.getOperacao() %>">
                        <label for="opcaoCategoria" name="operacao">Crédito</label>     

                        <input type="radio" id="opcaoCategoria"
                        name="categoria" value="credito">
                        <label for="opcaoCategoria" name="operacao">Débito</label>
                    </div> 
                    
                    <div>
                        <label for="date" class="col-form-label"><b>Data</b></label>
                        <input type="text" name="data" class="date form-control " placeholder="Digite a data" value="<%= lancamento.getData() %>">
                    </div>
                    
                    <div>
                        <label for="descricao" class="col-form-label"><b>Descrição</b></label>
                        <input type="text" name="descricao" class="form-control " placeholder="Digite a descrição" value="<%= lancamento.getDescricao() %>">
                    </div>
                    
                    <button type="submit" class="card mt-3 btn" style="min-width: 100px; margin: auto;">Cadastrar Lançamento</button>
                </div>
            </fieldset>
        </form>
        
        <script src="templates/jquery-3.4.1.min.js"></script>
        <script src="templates/jquery.mask.min.js"></script>
        
        <script>
            $(document).ready(function() {      
                $('.date').mask('0000-00-00');
                $('.valor').mask("#.##0,00", {reverse: true});
            });
            
	</script> 
    </body>
</html>
