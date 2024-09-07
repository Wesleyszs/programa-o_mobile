package com.example.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextEmailCadastro;
    private EditText editTextSenhaCadastro;
    private Button buttonCadastrar;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Inicializar os componentes da interface
        editTextEmailCadastro = findViewById(R.id.editTextEmailCadastro);
        editTextSenhaCadastro = findViewById(R.id.editTextSenhaCadastro);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

        // Inicializar o DAO para operações com o banco de dados
        userDAO = new UserDAO(this);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmailCadastro.getText().toString();
                String senha = editTextSenhaCadastro.getText().toString();

                if (email.isEmpty() || senha.isEmpty()) {
                  
                } else {
                    long result = userDAO.addUser(email, senha);
                    if (result != -1) {
                      
                    } else {
                      
                    }
                }
            }
        });
    }
}
