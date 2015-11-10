package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import jocimar_paulo.ifsp.boletofacil.R;

public class ActDadosSacado extends AppCompatActivity {

    public static int opcaoMenu;

    public void exibeMensagem(String mensagem){
        Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dados_sacado);

        Intent i = getIntent();
        opcaoMenu = i.getIntExtra("menu", 0);
        exibeMensagem(String.valueOf(opcaoMenu));
    }


}
