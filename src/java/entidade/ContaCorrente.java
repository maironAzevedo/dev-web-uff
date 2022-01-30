package entidade;

public class ContaCorrente {
    private int id;
    private int id_usuario;
    private String nome_conta;
    private String banco;
    private String agencia;
    private String conta_corrente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getNome() {
        return nome_conta;
    }

    public void setNome(String nome) {
        this.nome_conta = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta_corrente;
    }

    public void setConta(String conta) {
        this.conta_corrente = conta;
    }
}
