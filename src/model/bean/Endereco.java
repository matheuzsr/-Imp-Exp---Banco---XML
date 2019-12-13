package model.bean;

public class Endereco {

    private int idEndereco;
    private String Logradouro;
    private int Cep;
    private int Numero;
    private String Cidade;
    private String UF;
    private String Status;

    public Endereco(String Logradouro, int Cep, int Numero, String Cidade, String UF) {
        this.Status = "R";
        this.idEndereco = 0;
        this.Logradouro = Logradouro;
        this.Cep = Cep;
        this.Numero = Numero;
        this.Cidade = Cidade;
        this.UF = UF;
    }

    public Endereco(int id, String Logradouro, int Cep, int Numero, String Cidade, String UF) {
        this.idEndereco = id;
        this.Status = "N";
        this.Logradouro = Logradouro;
        this.Cep = Cep;
        this.Numero = Numero;
        this.Cidade = Cidade;
        this.UF = UF;
    }

    public Endereco() {
        this.Status = "N";
        this.idEndereco = 0;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int Cep) {
        this.Cep = Cep;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", Logradouro=" + Logradouro + ", Cep=" + Cep + ", Numero=" + Numero + ", Cidade=" + Cidade + ", UF=" + UF + ", Status=" + Status + '}';
    }



    @Override
    public boolean equals(Object o) {
        if (o instanceof Endereco) {
            Endereco e = (Endereco) o;
            if (e.getLogradouro() == this.getLogradouro() && e.getCep() == this.getCep()
                    && e.getNumero() == this.getNumero() && e.getCidade() == this.getCidade()
                    && e.getUF() == this.getUF()) {
                return true;
            }
        }
        return false;
    }

}
