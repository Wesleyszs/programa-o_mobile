package com.example.combustivel2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.combustivel2.R;
import com.example.mudartexto.R;

public class MainActivity extends AppCompatActivity {

    private EditText alcoolEditText;
    private EditText gasolinaEditText;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcoolEditText = findViewById(R.id.alcool);
        gasolinaEditText = findViewById(R.id.gasolina);
        resultadoTextView = findViewById(R.id.resultado);

        Button calcularButton = findViewById(R.id.button);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPreco();
            }
        });

        Button limparButton = findViewById(R.id.button2);
        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void calcularPreco() {
        try {
            double precoAlcool = Double.parseDouble(alcoolEditText.getText().toString());
            double precoGasolina = Double.parseDouble(gasolinaEditText.getText().toString());

            if (precoGasolina == 0) {
                resultadoTextView.setText("Preço da gasolina não pode ser zero.");
                return;
            }

            double resultado = precoAlcool / precoGasolina;
            if (resultado <= 0.7) {
                resultadoTextView.setText("Abasteça com álcool.");
            } else {
                resultadoTextView.setText("Abasteça com gasolina.");
            }
        } catch (NumberFormatException e) {
            resultadoTextView.setText("Por favor, insira valores válidos.");
        }
    }

    private void limparCampos() {
        alcoolEditText.setText("");
        gasolinaEditText.setText("");
        resultadoTextView.setText("Resultado");
    }
}
