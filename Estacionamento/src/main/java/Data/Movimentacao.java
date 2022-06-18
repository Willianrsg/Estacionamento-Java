
package Data;


import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Willian
 */
public class Movimentacao {
    private int id_movimentacao;
    private String placa;
    private String modelo;
    private Date data_entrada;
    private Time hora_entrada;
    //private Date data_saida;
   // private Date tempo;
   // private boolean valor_pago;

        
    
    //Metodo construtor
    public Movimentacao(){
        
    }
    
    //Metodos GETRER E SETTER

    public int getId_movimentacao() {
        return id_movimentacao;
    }

    public void setId_movimentacao(int id_movimentacao) {
        this.id_movimentacao = id_movimentacao;
    }

 

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }
    
    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }
    /*
    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public boolean isValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(boolean valor_pago) {
        this.valor_pago = valor_pago;
    }
    */
    
}



















