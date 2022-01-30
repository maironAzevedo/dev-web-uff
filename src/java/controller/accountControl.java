package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidade.ContaCorrente;
import model.contacorrenteDao;
        
@WebServlet(name = "accountControl", urlPatterns = {"/accountControl"})
public class accountControl extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        contacorrenteDao contaDAO = new contacorrenteDao();
        ArrayList<ContaCorrente> contas;
        ContaCorrente conta = new ContaCorrente();
        int contaId;
        
        String action = (String) request.getParameter("action");
        
        switch (action) {
            case "inicial":
<<<<<<< HEAD
                
                
                
                break;
                
=======
                contaId = Integer.parseInt(request.getParameter("id"));
                contas = contaDAO.buscaContaPorUser(contaId);
                request.setAttribute("contas", contas);
                RequestDispatcher get = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                get.forward(request, response);
                
                break;
            case "all":
                contas = contaDAO.listaContas();
                request.setAttribute("contas", contas);
                RequestDispatcher list = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                list.forward(request, response);
                
                break;
>>>>>>> 223db76544dd71e7db0a699876e6e996e7a3ecc6
            case "inserir":
                conta.setId(0);
                conta.setUserId(0);
                conta.setNome("");
                conta.setBanco("");
                conta.setAgencia("");
                conta.setConta(0);
                
                request.setAttribute("conta", conta);
                RequestDispatcher insert = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                insert.forward(request, response);
                
                break;
            case "update":
                contaId = Integer.parseInt(request.getParameter("id"));
                conta = contaDAO.buscaConta(contaId);
                
                request.setAttribute("conta", conta);
                RequestDispatcher update = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                update.forward(request, response);
                
                break;
            case "delete":
                contaId = Integer.parseInt(request.getParameter("id"));
                
                conta = contaDAO.buscaConta(contaId);
                contaDAO.deletarConta(contaId);
                contas = contaDAO.buscaContaPorUser(conta.getUserId());
                
                request.setAttribute("contas", contas);
                RequestDispatcher delete = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
                delete.forward(request, response);
                
                break;
            /*case "balancete":
                LancamentoDAO lancamentoDAO = new LancamentoDAO();
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Balancete balancete = new Balancete();
                double creditos_total = 0.0;
                double debitos_total = 0.0;
                contaId = Integer.parseInt(request.getParameter("id"));
                
                conta = contaDAO.get(contaId);
                balancete.setNome_conta(conta.getNome_conta());
                
                ArrayList<Lancamento> lancamentos = lancamentoDAO.getByConta(contaId);
                ArrayList<BalanceteRow> balanceteRows = new ArrayList<>();
                ArrayList<Categoria> categorias = categoriaDAO.getAll();
                
                for (int indexCategoria = 0; indexCategoria < categorias.size(); indexCategoria++) {
                    BalanceteRow balanceteRow = new BalanceteRow();
                    Categoria categoria = categorias.get(indexCategoria);
                    double creditos = 0.0;
                    double debitos = 0.0;
                    
                    balanceteRow.setNome(categoria.getDescricao());
                    for (int indexLancamento = 0; indexLancamento < lancamentos.size(); indexLancamento++) {
                        Lancamento lancamento = lancamentos.get(indexLancamento);
                        if (lancamento.getId_categoria() == categoria.getId()) {
                            if (lancamento.getOperacao().equals("C")) {
                                creditos += lancamento.getValor();
                            } else {
                                debitos += lancamento.getValor();
                            }
                        }
                    }
                    
                    creditos_total += creditos;
                    debitos_total += debitos;
                    balanceteRow.setCreditos(creditos);
                    balanceteRow.setDebitos(debitos);
                    balanceteRow.setPercentual_creditos(creditos / (creditos + debitos));
                    balanceteRow.setPercentual_debitos(debitos / (creditos + debitos));
                    
                    if (balanceteRow.getPercentual_creditos().compareTo(Double.NaN) == 0) {
                        balanceteRow.setPercentual_creditos(0.0);
                    }
                    
                    if (balanceteRow.getPercentual_debitos().compareTo(Double.NaN) == 0) {
                        balanceteRow.setPercentual_debitos(0.0);
                    }
                    
                    balanceteRows.add(balanceteRow);
                }
                
                BalanceteRow balanceteRow = new BalanceteRow();
                balanceteRow.setNome("Total");
                balanceteRow.setCreditos(creditos_total);
                balanceteRow.setDebitos(debitos_total);
                balanceteRow.setPercentual_creditos(creditos_total / (creditos_total + debitos_total));
                balanceteRow.setPercentual_debitos(debitos_total / (creditos_total + debitos_total));
                
                if (balanceteRow.getPercentual_creditos().compareTo(Double.NaN) == 0) {
                    balanceteRow.setPercentual_creditos(0.0);
                }

                if (balanceteRow.getPercentual_debitos().compareTo(Double.NaN) == 0) {
                    balanceteRow.setPercentual_debitos(0.0);
                }
                    
                balanceteRows.add(balanceteRow);
                
                balancete.setRows(balanceteRows);

                request.setAttribute("balancete", balancete);
                RequestDispatcher balanceteRD = getServletContext().getRequestDispatcher("/viewBalancete.jsp");
                balanceteRD.forward(request, response);
                
                break;*/
        }       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        contacorrenteDao contaDAO = new contacorrenteDao();
        request.setCharacterEncoding("UTF-8");
        String message = "";
        
        try {
            ContaCorrente conta = new ContaCorrente();
            if (request.getParameter("id_usuario") == null) {
                message = "'Id_usuario' is empty";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("nome_conta").equals("")) {
                message = "'Nome_conta' is empty";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("banco").equals("")) {
                message = "'Banco' is empty";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("agencia").equals("")) {
                message = "'Agencia' is empty";
                request.setAttribute("error", 1);
            }
            if (request.getParameter("conta_corrente").equals("")) {
                message = "'Conta_corrente' is empty";
                request.setAttribute("error", 1);
            }
            
            if (message.equals("")) {
                conta.setId(Integer.parseInt(request.getParameter("id")));
                conta.setUserId(Integer.parseInt(request.getParameter("id_usuario")));
                conta.setNome(request.getParameter("nomeConta"));
                conta.setBanco(request.getParameter("banco"));
                conta.setAgencia(request.getParameter("agencia"));
                conta.setConta(Integer.parseInt(request.getParameter("contaCorrente")));

                if (conta.getId() == 0) {
                    if (contaDAO.inserirConta(conta)) {
                        message = "Nova Conta!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Não Efetivado";
                        request.setAttribute("error", 1);
                    }
                } else {
                    if (contaDAO.alterarConta(conta)) {
                        message = "Conta Modificado!";
                        request.setAttribute("error", 0);
                    } else {
                        message = "Não Efetivado";
                        request.setAttribute("error", 1);
                    }
                }
            }
            
            request.setAttribute("message", message);
            
        } catch(NumberFormatException e) {
            message = "Error: " + e.getMessage();
            System.out.println(message);
            
            request.setAttribute("message", message);
            request.setAttribute("error", 1);
            
        } finally {
            ArrayList<ContaCorrente> contas;
            contas = contaDAO.buscaContaPorUser(Integer.parseInt(request.getParameter("id_usuario")));
            
            request.setAttribute("contas", contas);
            RequestDispatcher list = getServletContext().getRequestDispatcher("/conta-corrente.jsp");
            list.forward(request, response);
        }
    }
}