
package model.bean;


public class Aeronave {
    private int idAeronave;
    private String modelo;
    private String autonomia;
    private float capCombustivel;
    private float velocidade;
    private String numChassi;
    private String tipo;
    private String status;

    public Aeronave(int idAeronave, String modelo, String autonomia, float capacidade, float velocidade, String numChassi, String tipo) {
        this.status="N";
        this.idAeronave = idAeronave;
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.capCombustivel = capacidade;
        this.velocidade = velocidade;
        this.numChassi = numChassi;
        this.tipo = tipo;
    }
        public Aeronave(String modelo, String autonomia, float capacidade, float velocidade, String numChassi, String tipo) {
        this.status="N";
        this.idAeronave = 0;
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.capCombustivel = capacidade;
        this.velocidade = velocidade;
        this.numChassi = numChassi;
        this.tipo = tipo;
    }
    public Aeronave(){
        this.status="N";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    public float getCapCombustivel() {
        return capCombustivel;
    }

    public void setCapCombustivel(float capacidade) {
        this.capCombustivel = capacidade;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
                    
    
}
