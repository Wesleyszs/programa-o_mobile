package com.example.telalogin1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextSenha;
    private Button buttonLogin;
    private TextView textViewCadastro;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextSenha = findViewById(R.id.editTextTextPassword);
        buttonLogin = findViewById(R.id.button);
        textViewCadastro = findViewById(R.id.textViewCadastro);
        databaseHelper = new DatabaseHelper(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                if (databaseHelper.validarLogin(email, senha)) {
                    Intent intent = new Intent(MainActivity.this, activity_bem_vindo.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Senha inválida ou usuário não encontrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}
