
package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarTexto(View view){
        TextView texto=findViewById(R.id.resultado);
        texto.setText("Programando Mobile");
        }

    public static void SortearNumero(View view) {

        Random random = new Random();
        int numero = random.nextInt(11);


        TextView texto = view.getRootView().findViewById(R.id.resultado);


        texto.setText(String.valueOf(numero));
    }
}
