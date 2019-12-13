package model.bean;

public class Agendamento {

    private int idAgendamento;
    private float valor;
    private String data;
    private String hora;
    private String Status;

    public Agendamento(int idAgendamento, float valor, String data, String hora) {
        this.Status = "R";
        this.idAgendamento = idAgendamento;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
