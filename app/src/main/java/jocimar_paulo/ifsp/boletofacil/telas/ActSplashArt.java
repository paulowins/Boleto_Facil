package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jocimar_paulo.ifsp.boletofacil.R;

public class ActSplashArt extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_splash_art);

        //Aciona o metodo que abre a tela de Menu Principal apos aguardar o tempo especificado em milisegundo
        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    //Metodo run fica aguardando o termino da metodo onCreate
    public void run(){
        startActivity(new Intent(this, ActMenuPrincipal.class));
        finish();
    }
}
