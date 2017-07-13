package com.example.mvaguimaraes.rotatingwheel;

/**
 * Created by Mvaguimaraes on 3/9/16.
 */
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends Activity {
    private Usuario usuario = new Usuario();
    private EditText nomeEt;
    private EditText emailEt;
    private EditText passwordEt;
    private Button salvarBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        nomeEt = (EditText) findViewById(R.id.nome);
        emailEt = (EditText) findViewById(R.id.email);
        passwordEt = (EditText) findViewById(R.id.password);
        salvarBt = (Button) findViewById(R.id.button1);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                usuario.setId(bundle.getLong("id"));
                usuario.setNome(bundle.getString("nome"));
                usuario.setEmail(bundle.getString("email"));
                usuario.setPassword(bundle.getString("password"));

                nomeEt.setText(usuario.getNome());
                emailEt.setText(usuario.getEmail());
                passwordEt.setText(usuario.getPassword());


                salvarBt.setVisibility(View.GONE);
            }
        }
    }


    public void salvarUsuario(View view){
        usuario.setNome(nomeEt.getText().toString());
        usuario.setEmail(emailEt.getText().toString());
        usuario.setPassword(passwordEt.getText().toString());


        BD bd = new BD(this);
        bd.inserir(usuario);

        System.out.println(" EMAIL " + usuario.getEmail() + " SENHA " + usuario.getPassword());

        Toast.makeText(this, "Registration complete!", Toast.LENGTH_SHORT).show();
    }

}
