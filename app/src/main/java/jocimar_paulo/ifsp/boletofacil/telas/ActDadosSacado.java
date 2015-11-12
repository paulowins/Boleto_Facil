package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import jocimar_paulo.ifsp.boletofacil.R;
import jocimar_paulo.ifsp.boletofacil.builders.BBBoletoBuilder;
import jocimar_paulo.ifsp.boletofacil.builders.Boleto;
import jocimar_paulo.ifsp.boletofacil.builders.Director;

public class ActDadosSacado extends AppCompatActivity {

    //Variaveis globais para substituir a falta do banco de dados.

    //Qual botão chamou a tela 1,2,3 tipos de serviços / 4,5,6 tipos de multas
    public static int opcaoMenu;
    //Armazena os dados digitados do sacado
    public static String nomeSacado, cpfSacado;
    //Armazena o boleto construído pelo builder
    public static Boleto boleto;

    //Variaveis locais
    private EditText edtNomeSacado, edtCpf;
    private Director director;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dados_sacado);

        edtNomeSacado = (EditText) findViewById(R.id.edtNomeSacado);
        edtCpf = (EditText) findViewById(R.id.edtCpf);

        Intent i = getIntent();
        opcaoMenu = i.getIntExtra("menu", 0);


    }

    public void abrirBoleto(View v){
        nomeSacado = edtNomeSacado.getText().toString();
        cpfSacado = edtCpf.getText().toString();



        /*Os boletos de serviços (Opção 1, 2 e 3) são
        pagos atraves de boletos do banco do Brasil.
        Ja as multas (Opção 4,5 e 6) são pagos por boletos
        do Itau
         */
        if (opcaoMenu == 1 || opcaoMenu == 2 || opcaoMenu == 3) {
            director = new Director(new BBBoletoBuilder());
        } else if (opcaoMenu == 4 || opcaoMenu == 5 || opcaoMenu == 6) {

        }

        if (director != null) {
            //Manda construir o boleto
            director.buildingBoleto();

            //Recebe o boleto construído pelo Builder
            boleto = director.getBoleto();
        }

        Intent i = new Intent(this, GeraBoleto.class);
        startActivityForResult(i, RESULT_OK);

    }

    public void exibeMensagem(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
    }


}
