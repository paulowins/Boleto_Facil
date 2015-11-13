package jocimar_paulo.ifsp.boletofacil.builders;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import jocimar_paulo.ifsp.boletofacil.dados.Conexao;


/**
 * Created by paulo on 10/11/15.
 */
public class BBBoletoBuilder extends BoletoBuilder {



    @Override
    public void buildSacado() {
        boleto.Sacado = Conexao.nomeSacado + " - " +Conexao.cpfSacado;
    }

    @Override
    public void buildCedente() {
        switch (Conexao.opcaoMenu){
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
        //Constroi o valor com base na opção escolhida
        switch (Conexao.opcaoMenu){
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
                boleto.Valor = 200f;
                break;
            case 6:
                boleto.Valor = 300.99f;
                break;
        }
    }

    @Override
    public void buildVencimento() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 15);
        boleto.Vencimento = calendar;
    }

    @Override
    public void buildNossoNumero() {
        Random geraNumero = new Random();
        int numero = (geraNumero.nextInt(8)+1)*10000;
        boleto.nossoNumero = numero;
    }

    @Override
    public void buildCodBarras() {
        StringBuilder sb = new StringBuilder();
        sb.append("001"); //Identificação do banco
        sb.append("9"); //Codigo da moeda (9 = Real)
        sb.append(boleto.nossoNumero); //5 digitos livres
        sb.append("0"); //digito verificador
        sb.append("");
        boleto.CodBarras = sb.toString();
    }

    @Override
    public void buildObsercacao() {

    }
}
