package com.example.atividade03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener
{

    private Button girar;
    private ImageView imagem;
    private ImageView imagem2;// variáveis
    private Context context;
    private Button alfa;
    private Button deslocar;
    private Button escala;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // ajustando layout
        setContentView(R.layout.tela_principal);

        context=MainActivity.this;     // obtendo contexto

        // vinculando as variáveis com as componentes da tela

        girar=findViewById(R.id.girar);
        alfa = findViewById(R.id.alfa);
        deslocar = findViewById(R.id.deslocar);
        escala = findViewById(R.id.escala);

        imagem=findViewById(R.id.imagem);
        imagem2 = findViewById(R.id.imagem2);



        girar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // carregando animação
                Animation anim =  AnimationUtils.loadAnimation(context,R.anim.rotacao);
                anim.setAnimationListener(MainActivity.this);
                imagem.requestLayout();
                imagem.setAnimation(anim);

                imagem2.requestLayout();
                imagem2.setAnimation(anim);// animação no imageView
                anim.start();              // iniciando a animação
            }
        });

        alfa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Animation anim = AnimationUtils.loadAnimation(context, R.anim.alfa);
                anim.setAnimationListener(MainActivity.this);
                imagem.requestLayout();
                imagem.setAnimation(anim);

                imagem2.requestLayout();
                imagem2.setAnimation(anim);// animação no imageView
                anim.start();
            }
        });
        escala.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Animation anim = AnimationUtils.loadAnimation(context, R.anim.escala);
                anim.setAnimationListener(MainActivity.this);
                imagem.requestLayout();
                imagem.setAnimation(anim);

                imagem2.requestLayout();
                imagem2.setAnimation(anim);// animação no imageView
                anim.start();
            }
        });
        deslocar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Animation anim = AnimationUtils.loadAnimation(context, R.anim.deslocar);
                anim.setAnimationListener(MainActivity.this);
                imagem.requestLayout();
                imagem.setAnimation(anim);

                imagem2.requestLayout();
                imagem2.setAnimation(anim);// animação no imageView
                anim.start();

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation)
    {
        girar.setEnabled(false);    // desabilita o botão
        alfa.setEnabled(false);
        escala.setEnabled(false);
        deslocar.setEnabled(false);

    }

    @Override
    public void onAnimationEnd(Animation animation)
    {
        girar.setEnabled(true);
        alfa.setEnabled(true);
        escala.setEnabled(true);
        deslocar.setEnabled(true);
    }

    @Override
    public void onAnimationRepeat(Animation animation)
    {

    }
}

