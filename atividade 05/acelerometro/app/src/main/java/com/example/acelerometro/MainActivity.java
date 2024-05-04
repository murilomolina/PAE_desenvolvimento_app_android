package com.example.acelerometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener

{

    private SensorManager acelerometro;

    //Variaveis para o eixo x:
    private TextView ax;
    private double ax2;

    // variaveis para o eixo y:
    private TextView ay;
    private double ay2;

    // Variaveis para o eixo z:
    private TextView az;
    private double az2;

    // Resultante
    private TextView result;
    private double resultante;

    private String aux;
    private Context contexto;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1);

        ax=findViewById(R.id.acelx);

        ay = findViewById(R.id.acely);

        az = findViewById(R.id.acelz);

        result = findViewById(R.id.resultante);

        contexto=MainActivity.this;   // obtendo contexto

        // configurando o acesso ao sensor de aceleração
        acelerometro=(SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro.registerListener(this, acelerometro.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    // rotina que é executada quando houver mudança na precisão do sensor
    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }


    // rotina que é executada quando houver mudança na aceleração
    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            ax2 = sensorEvent.values[0];     // lendo os valores das acelerações
            aux = "\nax= " + String.valueOf(ax2) + "m/s^2";
            ax.setText(aux);               // exibindo nas caixas de texto

            // Para aceleração no eixo y
            ay2 = sensorEvent.values[1];     // lendo os valores das acelerações
            aux = "\nay= " + String.valueOf(ay2) + "m/s^2";
            ay.setText(aux);               // exibindo nas caixas de texto

            // Para aceleração no eixo z:
            az2 = sensorEvent.values[2];     // lendo os valores das acelerações
            aux = "\naz= " + String.valueOf(az2) + "m/s^2";
            az.setText(aux);               // exibindo nas caixas de texto

            // Resultante:
            resultante = Math.sqrt(ax2 * ax2 + ay2 * ay2);
            aux = "\nResultante= " + String.valueOf(resultante) + " m/s^2";
            result.setText(aux);

            if (ay2 > 11) {
                Toast.makeText(contexto, "O celular está caindo!!!", Toast.LENGTH_LONG).show(); // exibe mensagem
            }
        }
    }

}