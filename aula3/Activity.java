package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import com.example.mudartexto.R;

public class MainActivity extends AppCompatActivity {

    private EditText caixaPeso;
    private EditText caixaAltura;
    private TextView resultadoIMC;
    private TextView mensagem;
    private Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar os elementos da UI
        caixaPeso = findViewById(R.id.caixapeso);
        caixaAltura = findViewById(R.id.caixaaltura);
        resultadoIMC = findViewById(R.id.editTextNumber4);
        mensagem = findViewById(R.id.textView6);
        botaoCalcular = findViewById(R.id.button);

        // Definir o OnClickListener para o botão
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        // Obter valores dos EditText
        String pesoStr = caixaPeso.getText().toString();
        String alturaStr = caixaAltura.getText().toString();

        // Verificar se os campos estão preenchidos
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            resultadoIMC.setText("");
            mensagem.setText("Preencha todos os campos");
            return;
        }

        // Converter os valores para float
        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr) / 100; // Converter altura de cm para metros

        // Verificar se a altura não é zero para evitar divisão por zero
        if (altura == 0) {
            resultadoIMC.setText("");
            mensagem.setText("Altura inválida");
            return;
        }

        // Calcular o IMC
        float imc = peso / (altura * altura);

        // Atualizar o TextView com o resultado do IMC
        resultadoIMC.setText(String.format("IMC: %.2f", imc));

        // Atualizar a mensagem com base no IMC
        String mensagemIMC = obterMensagemIMC(imc);
        mensagem.setText(mensagemIMC);
    }

    private String obterMensagemIMC(float imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso ideal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
