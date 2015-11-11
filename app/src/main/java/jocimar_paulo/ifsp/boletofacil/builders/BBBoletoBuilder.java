package jocimar_paulo.ifsp.boletofacil.builders;

import java.util.Calendar;

import jocimar_paulo.ifsp.boletofacil.telas.ActDadosSacado;

/**
 * Created by paulo on 10/11/15.
 */
public class BBBoletoBuilder extends BoletoBuilder {



    @Override
    public void buildSacado() {

    }

    @Override
    public void buildCedente() {
        switch (ActDadosSacado.opcaoMenu){
            case 1:
            case 4:
                boleto.Cedente = "Prefeitura Municipal - Meio Ambiente";
                break;
            case 2:
            case 5:
                boleto.Cedente = "Prefeitura Municipal - Vigilância Sanitária";
                break;
            case 3:
            case 6:
                boleto.Cedente = "Prefeitura Municipal - Engenharia";
                break;
        }

    }

    @Override
    public void buildValor() {
        switch (ActDadosSacado.opcaoMenu){
            case 1:
                boleto.Valor = 33.90f;
                break;
            case 2:
                boleto.Valor = 540;
                break;
            case 3:
                boleto.Valor = 90;
                break;
            case 4:
                boleto.Valor = 230.60f;
                break;
            case 5:
            case 6:
                boleto.Valor = 300.99f;
                break;
        }
    }

    @Override
    public void buildVencimento() {

    }

    @Override
    public void buildNossoNumero() {

    }

    @Override
    public void buildObsercacao() {

    }
}
