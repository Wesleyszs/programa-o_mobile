package com.example.aleatorio;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Integer> numerosSorteados = new ArrayList<>();
    private TextView textoResultado;
    private TextView textoHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = findViewById(R.id.resultado);
        textoHistorico = findViewById(R.id.historico);

        // Configuração de Insets se necessário
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void SortearNumero(View view) {
        int numero = new Random().nextInt(101); 
        numerosSorteados.add(numero); 

        // Atualiza o TextView com o número sorteado atual
        textoResultado.setText("Número sorteado: " + numero);

        // Atualiza o TextView com o histórico de números sorteados
        StringBuilder historico = new StringBuilder("Histórico dos números sorteados:\n");
        for (Integer num : numerosSorteados) {
            historico.append(num).append("\n");
        }
        textoHistorico.setText(historico.toString());
    }
}
