package jocimar_paulo.ifsp.boletofacil.builders;

/**
 * Created by paulo on 10/11/15.
 */
public class Director {
    private BoletoBuilder builderBoleto;

    public Director(BoletoBuilder builderBoleto){
        this.builderBoleto = builderBoleto;
    }

    /**
     * Constroi o boleto chamando os metodos builds
     * de cada atributo
     */
    public void buildingBoleto(){
        builderBoleto.buildSacado();
        builderBoleto.buildCedente();
        builderBoleto.buildValor();
        builderBoleto.buildVencimento();
        builderBoleto.buildNossoNumero();
        builderBoleto.buildObsercacao();
    }

    //retorna o Boleto construído
    public Boleto getBoleto(){
        return builderBoleto.getBoleto();
    }

}
