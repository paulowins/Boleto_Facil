package jocimar_paulo.ifsp.boletofacil.builders;

import java.util.Calendar;

/**
 * Created by paulo on 05/11/15.
 */
public class Boleto {
    String Sacado;
    String Cedente;
    float Valor;
    Calendar Vencimento;
    int nossoNumero;
    String CodBarras;
    String Observacao;


    public String getSacado() {
        return Sacado;
    }

    public String getCedente() {
        return Cedente;
    }

    public float getValor() {
        return Valor;
    }

    public Calendar getVencimento() {
        return Vencimento;
    }

    public int getNossoNumero() {
        return nossoNumero;
    }

    public String getCodBarras() {
        return CodBarras;
    }

    public String getObservacao() {
        return Observacao;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "Sacado='" + Sacado + '\'' +
                ", Cedente='" + Cedente + '\'' +
                ", Valor=" + Valor +
                ", Vencimento=" + Vencimento.getTime() +
                ", nossoNumero=" + nossoNumero +
                ", CodBarras='" + CodBarras + '\'' +
                ", Observacao='" + Observacao + '\'' +
                '}';
    }
}
