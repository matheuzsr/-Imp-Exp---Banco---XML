package model.bean;

public class Pessoa {

    private int idPessoa;
    private String Nome;
    private int Rg;
    private String Cpf;
    private int idEndereco;
    private String Status;

    public Pessoa(int idPessoa, String Nome, int Rg, String Cpf, int idEnd, String Status) {
        this.idPessoa = idPessoa;
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.idEndereco = idEnd;
        this.Status = Status;
    }

    public Pessoa(String Nome, int Rg, String Cpf,int idEnd) {
        this.idPessoa = 0;
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.idEndereco = idEnd;
        this.Status = "N";
    }

    public Pessoa() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getRg() {
        return Rg;
    }

    public void setRg(int Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEnd) {
        this.idEndereco = idEnd;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", Nome=" + Nome + ", Rg=" + Rg + ", Cpf=" + Cpf + ", end=" + idEndereco + ", Status=" + Status + '}';
    }




}
