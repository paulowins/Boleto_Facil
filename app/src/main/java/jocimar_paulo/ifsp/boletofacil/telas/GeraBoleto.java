package jocimar_paulo.ifsp.boletofacil.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import jocimar_paulo.ifsp.boletofacil.R;
import jocimar_paulo.ifsp.boletofacil.builders.Boleto;
import jocimar_paulo.ifsp.boletofacil.dados.Conexao;

public class GeraBoleto extends AppCompatActivity {

    TextView lblBoleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gera_boleto);

        lblBoleto = (TextView) findViewById(R.id.lblBoleto);

        //Boleto b = ActDadosSacado.boleto;
        lblBoleto.setText(Conexao.boleto.toString());

    }
}
