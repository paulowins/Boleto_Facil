package jocimar_paulo.ifsp.boletofacil.builders;

import jocimar_paulo.ifsp.boletofacil.dados.Conexao;
import jocimar_paulo.ifsp.boletofacil.telas.ActDadosSacado;

/**
 * Created by paulo on 12/11/15.
 */
public class ItauBoletoBuilder extends BoletoBuilder {

    @Override
    public void buildSacado() {

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

    }

    @Override
    public void buildVencimento() {

    }

    @Override
    public void buildNossoNumero() {

    }

    @Override
    public void buildCodBarras() {

    }

    @Override
    public void buildObsercacao() {

    }
}
