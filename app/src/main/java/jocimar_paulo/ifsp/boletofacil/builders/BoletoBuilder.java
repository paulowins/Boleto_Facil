package jocimar_paulo.ifsp.boletofacil.builders;

import java.util.Calendar;

/**
 * Created by paulo on 06/11/15.
 */
public abstract class BoletoBuilder {

    protected Boleto boleto;

    public BoletoBuilder(){
        boleto = new Boleto();
    }

    public abstract void buildSacado();
    public abstract void buildCedente();
    public abstract void buildValor();
    public abstract void buildVencimento();
    public abstract void buildNossoNumero();
    public abstract void buildObsercacao();

    public Boleto getBoleto(){
        return boleto;
    }
}
