package jocimar_paulo.ifsp.boletofacil.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jocimar_paulo.ifsp.boletofacil.R;

public class ActMenuPrincipal extends AppCompatActivity {



    public void abrirMultas(View v){
        Intent i = new Intent(this, ActMultas.class);
        startActivityForResult(i, RESULT_OK);
    }

    public void abrirServicos(View v){
        Intent i = new Intent(this, ActServicos.class);
        startActivityForResult(i, RESULT_OK);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_menu_principal);
    }
}
