package jocimar_paulo.ifsp.boletofacil.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import jocimar_paulo.ifsp.boletofacil.R;

public class GeraBoleto extends AppCompatActivity {

    TextView lblBoleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gera_boleto);

        lblBoleto = (TextView) findViewById(R.id.lblBoleto);
        lblBoleto.setText(ActDadosSacado.boleto.toString());
    }
}
