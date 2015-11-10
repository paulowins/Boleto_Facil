package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jocimar_paulo.ifsp.boletofacil.R;

public class ActMultas extends AppCompatActivity {



    public void abrirDadosSacado(View v){
        Intent i = new Intent(this,ActDadosSacado.class);
        //adiciona uma put para que a tela possa obter de qual botão foi acionada.
        i.putExtra("menu", 1);
        startActivityForResult(i, RESULT_OK);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_multas);
    }
}
