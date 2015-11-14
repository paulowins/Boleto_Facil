package jocimar_paulo.ifsp.boletofacil.dados;

import jocimar_paulo.ifsp.boletofacil.builders.Boleto;

/**
 * Created by paulo on 12/11/15.
 * Contem variaveis globais para substituir a falta do banco de dados ou conexão externa.
 */
public class Conexao {


    /*Qual botão chamou a tela
    tipos de serviços 1 - Poda de Árvores
                      2 - Alvará de Funcionamento
                      3 - Licença para Obras
    tipos de multas  4 - Irregularidade em Terrenos
                     5 - Irregularidade Sanitária
                     6 - Irregularidade em Obras
     */
    public static int opcaoMenu;

    //Armazena os dados digitados do sacado
    public static String nomeSacado, cpfSacado;
    //Armazena o boleto construído pelo builder
    public static Boleto boleto;

}
