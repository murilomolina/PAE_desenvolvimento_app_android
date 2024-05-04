package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText raio; // proveniente da entrada da esfera, porem utilizado no calculo do circulo
    private EditText largura;
    private TextView resposta;
    private Button botaoVolumeEsfera;
    private Button botaoVolumeCubo;
    private Button botaoPerimetroEsfera;
    private double x; // variavel criada para utilizar como atribuição do valor que será exibido na resposta
    private double r; // variavel para chamar o valor do raio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1); // Definir layout

        // Vincular os elementos da tela com as variaveis
        raio = findViewById(R.id.raio);
        largura = findViewById(R.id.largura);
        botaoVolumeEsfera = findViewById(R.id.botaoVolumeEsfera);
        botaoVolumeCubo = findViewById(R.id.botaoVolumeCubo);
        botaoPerimetroEsfera = findViewById((R.id.botaoPerimetroEsfera));
        resposta = findViewById(R.id.resposta);

        //rotina botaoVolumeEsfera
        botaoVolumeEsfera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculo do volume da esfera
                x = Double.parseDouble(raio.getText().toString());
                x = 4*Math.PI*x*x*x/3;
                // exibindo a resposta
                resposta.setText(String.valueOf(x));
            }
        });
        //rotina botaoVolumeCubo
        botaoVolumeCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculo do volume do CUBO
                r = Double.parseDouble(largura.getText().toString());
                x = r*r*r;
                // exibindo a resposta
                resposta.setText(String.valueOf(x));
            }
        });

        // rotina botaoPerimetroEsfera MUDAR PARA botaoPerimetroCirculo.
        botaoPerimetroEsfera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // calculo do perimetro da esfera
                r = Double.parseDouble(raio.getText().toString());
                x = 2*Math.PI*r;
                resposta.setText(String.valueOf(x)); // definir limite de casas decimais
            }
        });

    }
}