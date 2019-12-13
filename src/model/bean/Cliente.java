
package model.bean;

public class Cliente {
    private int idCliente;
    private String nome;
    private int rg;
    private int cpf;

    public Cliente(int idCliente, String nome, int rg, int cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
}
