package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jocimar_paulo.ifsp.boletofacil.R;

public class ActMultas extends AppCompatActivity {

    public void abrirDadosSacado(View v){
        Intent i = new Intent(this,ActDadosSacado.class);

        //Obtem o texto do botão
        Button botao = (Button)  v;
        CharSequence a = botao.getText();

        //adiciona uma put para que a tela possa obter de qual botão foi acionada.
        if(a.equals("Irregularidade em Terrenos")){
            i.putExtra("menu", 4);
        }else if(a.equals("Irregularidade Sanitária")){
            i.putExtra("menu", 5);
        }else if(a.equals("Irregularidade em Obras")){
            i.putExtra("menu", 6);
        }

        startActivityForResult(i, RESULT_OK);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_multas);
    }
}
