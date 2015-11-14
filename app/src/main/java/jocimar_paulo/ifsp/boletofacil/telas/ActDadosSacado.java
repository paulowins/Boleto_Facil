package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import jocimar_paulo.ifsp.boletofacil.builders.ItauBoletoBuilder;
import jocimar_paulo.ifsp.boletofacil.dados.Conexao;
import jocimar_paulo.ifsp.boletofacil.R;
import jocimar_paulo.ifsp.boletofacil.builders.BBBoletoBuilder;
import jocimar_paulo.ifsp.boletofacil.builders.Director;

public class ActDadosSacado extends AppCompatActivity {

    private EditText edtNomeSacado, edtCpf;
    private Director director;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dados_sacado);

        edtNomeSacado = (EditText) findViewById(R.id.edtNomeSacado);
        edtCpf = (EditText) findViewById(R.id.edtCpf);

        Intent i = getIntent();
        Conexao.opcaoMenu = i.getIntExtra("menu", 0);


    }

    public void abrirBoleto(View v){
        Conexao.nomeSacado = edtNomeSacado.getText().toString();
        Conexao.cpfSacado = edtCpf.getText().toString();



        /*Os boletos de serviços (Opção 1, 2 e 3) são
        pagos atraves de boletos do banco do Brasil.
        Ja as multas (Opção 4,5 e 6) são pagos por boletos
        do Itau
         */
        if (Conexao.opcaoMenu == 1 || Conexao.opcaoMenu == 2 || Conexao.opcaoMenu == 3) {
            director = new Director(new BBBoletoBuilder());
        } else if (Conexao.opcaoMenu == 4 || Conexao.opcaoMenu == 5 || Conexao.opcaoMenu == 6) {
            director = new Director(new ItauBoletoBuilder());
        }

        if (director != null) {
            //Manda construir o boleto
            director.buildingBoleto();

            //Recebe o boleto construído pelo Builder
            Conexao.boleto = director.getBoleto();
        }

        Intent i = new Intent(this, GeraBoleto.class);
        startActivityForResult(i, RESULT_OK);

    }

    public void exibeMensagem(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
    }


}
