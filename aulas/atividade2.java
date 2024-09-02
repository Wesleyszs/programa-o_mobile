package com.example.frases_aleatorios1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarFrases(View view) {
        TextView texto = findViewById(R.id.RESULTADO);
        int numero = new Random().nextInt(5);
        String vetFrase[]={"Se não acreditares em ti próprio, ninguém mais acreditará ",
                "Eu sou um jogador que se entrega a 100%, não há meio-termo para mim ",
                "Eu trabalho muito, todos os dias, para ser o melhor. ",
                "Não me compares com ninguém. Estou muito bem com o que sou e com o que faço ",
                "Eu sou o melhor jogador do mundo, sem dúvida." };
        texto.setText(vetFrase[numero]);

    }
}



