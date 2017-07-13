package com.example.mvaguimaraes.rotatingwheel;

/**
 * Created by Mvaguimaraes on 3/9/16.
 */
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;

import android.content.Intent;

import android.widget.Button;

public class Login extends Activity {
    Button b1, b2;
    EditText ed1, ed2;
    TextView tx1;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addListenerOnButton();
        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        b2 = (Button) findViewById(R.id.button2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BD bd = new BD(Login.this);
                Usuario usuario = bd.buscar(ed1.getText().toString());

                System.out.println(" EMAIL " + ed1.getText().toString());

                if (ed1.getText().toString().equals(usuario.getEmail()) &&
                        ed2.getText().toString().equals(usuario.getPassword())) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));
                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

    }
    public void addListenerOnButton() {
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new OnClickListener() {
                                  @Override
                                  public void onClick(View arg0) {
                                      Intent browserIntent =
                                              new Intent(Login.this, Cadastro.class);
                                      startActivity(browserIntent);
                                  }
                                  }
        );
    }


}