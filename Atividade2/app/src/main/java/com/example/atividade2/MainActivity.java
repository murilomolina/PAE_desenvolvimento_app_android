package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button botao;      // variáveis
    private Context context;
    private ImageView imagem;
    private Button carregar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);    // vinculando o layout

        context=MainActivity.this;

        botao=findViewById(R.id.botao_tela2);
        carregar=findViewById(R.id.carregar);
        imagem=findViewById(R.id.imagem);           // vinculando as variáveis com as componentes

        // evento do botão
        botao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mintent = new Intent(context,tela2.class);
                startActivity(mintent);       // mudando para a tela 2
                finish();                     // fecha a tela atual

            }
        });

       // carregar.setOnClickListener(new View.OnClickListener()
        //{
        //    @Override

        //    public void onClick(View view)
        //    {
        //    imagem.setImageResource(R.drawable.flash);   // carrega a imagem na ImageView
        //    }
        //});






    }
}