package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText raio;
    private EditText largura;
    private TextView resposta;
    private Button botao1;
    private Button botao2;
    private double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1); // Definir layout

        // Vincular os elementos da tela com as variaveis
        raio = findViewById(R.id.raio);
        largura = findViewById(R.id.largura);
        botao1 = findViewById(R.id.botao1);
        botao2 = findViewById(R.id.botao2);
        resposta = findViewById(R.id.resposta);

        //rotina botão 1
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculo do volume da esfera
                x = Double.parseDouble(raio.getText().toString());
                x = 4*Math.PI*x*x*x/3;
                // exibindo a resposta
                resposta.setText(String.valueOf(x));
            }
        });
        //rotina botão 2
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculo do volume do CUBO
                x = Double.parseDouble(largura.getText().toString());
                x = x*x*x;
                // exibindo a resposta
                resposta.setText(String.valueOf(x));
            }
        });

    }
}