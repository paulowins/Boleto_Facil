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
        boleto.Sacado = Conexao.nomeSacado + " - " + Conexao.cpfSacado;
    }

    @Override
    public void buildCedente() {
        switch (Conexao.opcaoMenu) {
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
        switch (Conexao.opcaoMenu) {
            case 1:
                boleto.Valor = 33.95f;
                break;
            case 2:
                boleto.Valor = 540.55f;
                break;
            case 3:
                boleto.Valor = 90.01f;
                break;
            case 4:
                boleto.Valor = 230.69f;
                break;
            case 5:
                boleto.Valor = 200.01f;
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
        int numero = (geraNumero.nextInt(8) + 1) * 10000;
        boleto.nossoNumero = numero;
    }

    @Override
    public void buildCodBarras() {
        StringBuilder sb = new StringBuilder();
        sb.append("001."); //Identificação do banco
        sb.append("9."); //Codigo da moeda (9 = Real)
        sb.append(boleto.nossoNumero + "."); //5 digitos livres

        int aux = boleto.nossoNumero / 10001;
        sb.append(aux + "."); //digito verificador

        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(9)); //gera 11 digitos lives
        }

        sb.append(".");
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(9)); //gera 11 digitos lives
        }
        sb.append(".");

        //Calcula o número de dias decorridos desde a data-base — 07/10/1997 (Febraban)
        Calendar dataBase = Calendar.getInstance();
        dataBase.set(1997, 10, 7); // 07/10/1997
        sb.append(diffInDays(boleto.Vencimento.getTime(), dataBase.getTime()));  //Adiona o numero de referencia ao vencimento
        sb.append(".");

        //coloca o valor e comprementa com zeros na frente
        String valor = String.valueOf(boleto.Valor);
        while (valor.length() <= 10) {
            valor = "0" + valor;
        }
        sb.append(valor); //10 digito  para valor

        boleto.CodBarras = sb.toString();
    }

    @Override
    public void buildObsercacao() {
        boleto.Observacao =  "" +
                "O boleto deve ser impresso e pago nas agencias do Banco do Brasil." +
                " Não aceitar após o vencimento." +
                " Levar Comprovante no dia da solicitação.";
    }

    /**
     * Retorna o numero de dias entre duas datas
     *
     * @param d1 dataMaior
     * @param d2 DataMenor
     * @return int numero de dias
     */
    private int diffInDays(Date d1, Date d2) {
        int MILLIS_IN_DAY = 86400000;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        c1.set(Calendar.MILLISECOND, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.HOUR_OF_DAY, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        c2.set(Calendar.MILLISECOND, 0);
        c2.set(Calendar.SECOND, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        return (int) ((c1.getTimeInMillis() - c2.getTimeInMillis()) / MILLIS_IN_DAY);
    }
}
