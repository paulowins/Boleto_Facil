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
    String Observacao;


    @Override
    public String toString() {
        return "Boleto{" +
                "Sacado='" + Sacado + '\'' +
                ", Cedente='" + Cedente + '\'' +
                ", Valor=" + Valor +
                ", Vencimento=" + Vencimento +
                ", nossoNumero=" + nossoNumero +
                ", Observacao='" + Observacao + '\'' +
                '}';
    }
}
