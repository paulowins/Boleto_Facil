package jocimar_paulo.ifsp.boletofacil.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import jocimar_paulo.ifsp.boletofacil.R;
import jocimar_paulo.ifsp.boletofacil.dados.Conexao;

public class GeraBoleto extends AppCompatActivity {

    ImageView imvLogo;
    EditText edtCodBarras;
    EditText edtCedente;
    EditText edtSacado;
    EditText edtObs;
    EditText edtNossoNum;
    EditText edtVencto;
    EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gera_boleto);

        imvLogo = (ImageView) findViewById(R.id.imvLogo);
        edtCodBarras = (EditText) findViewById(R.id.edtCodBarras);
        edtCedente = (EditText) findViewById(R.id.edtCedente);
        edtSacado = (EditText) findViewById(R.id.edtSacado);
        edtObs = (EditText) findViewById(R.id.edtObs);
        edtNossoNum = (EditText) findViewById(R.id.edtNossoNum);
        edtVencto = (EditText) findViewById(R.id.edtVencto);
        edtValor = (EditText) findViewById(R.id.edtValor);

        popularBoleto();

    }

    public void popularBoleto(){

        // Trocando a imagem do boleto

        edtCodBarras.setText(Conexao.boleto.getCodBarras());
        edtCedente.setText(Conexao.boleto.getCedente());
        edtSacado.setText(Conexao.boleto.getSacado());
        edtObs.setText(Conexao.boleto.getObservacao());
        edtNossoNum.setText(String.valueOf(Conexao.boleto.getNossoNumero()));

        // Conversão da data para uma visualização amigavél
        Date data =  Conexao.boleto.getVencimento().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(data);
        edtVencto.setText(dataFormatada);

        edtValor.setText("R$ " + String.valueOf(Conexao.boleto.getValor()));

        trocarIconeBanco();

    }

    public void trocarIconeBanco(){
        String codBarras = Conexao.boleto.getCodBarras();

        // Identificando o banco pelo 3 primeiros caracteres do Cod. Barras
        String codBanco = codBarras.substring(0,3);

        if( codBanco.equals( "001" ) ){
            imvLogo.setImageResource(R.drawable.logo_bb);
        } else if (codBanco.equals( "341" ) ){
            imvLogo.setImageResource(R.drawable.logo_itau);
        }
    }
}
