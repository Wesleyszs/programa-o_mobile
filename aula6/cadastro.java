package com.example.telalogin1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextSenha;
    private Button buttonCadastrar;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextEmail = findViewById(R.id.editTextTextEmail);
        editTextSenha = findViewById(R.id.editTextTextSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        databaseHelper = new DatabaseHelper(this);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        boolean isRegistered = databaseHelper.cadastrar(email, senha);
                        if (isRegistered) {
                            Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            finish(); // Fecha a atividade de cadastro
                        } else {
                            Toast.makeText(CadastroActivity.this, "Erro ao cadastrar. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(CadastroActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
