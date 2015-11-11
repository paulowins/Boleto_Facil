package jocimar_paulo.ifsp.boletofacil.builders;

/**
 * Created by paulo on 10/11/15.
 */
public class Director {
    protected BoletoBuilder builderBoleto;

    public Director(BoletoBuilder builderBoleto){
        this.builderBoleto = builderBoleto;
    }

    public void building(){
        builderBoleto.buildSacado();
    }
}
