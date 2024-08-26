package com.example.aula1;

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


    public void SortearNumero(View view){
        int numero=new Random().nextInt(11);
        TextView texto=findViewById(R.id.resultado);
        texto.setText("numero sorteado: "+ numero);
    }
}
