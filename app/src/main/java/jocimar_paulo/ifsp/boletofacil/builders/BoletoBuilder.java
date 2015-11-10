package jocimar_paulo.ifsp.boletofacil.builders;

import java.util.Calendar;

/**
 * Created by paulo on 06/11/15.
 */
public abstract class BoletoBuilder {

    Boleto boleto = null;

    public BoletoBuilder(){
        boleto = new Boleto();
    }
    public abstract void buildSacado(String sacado);
    public abstract void buildCedente(String cedente);
    public abstract void buildValor(float valor);
    public abstract void buildVencimento(Calendar vencimento);
    public abstract void buildNossoNumero(int nossoNumero);
    public abstract void buildObsercacao(String obs);
}
