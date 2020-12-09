package com.example.poke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button boton;
    Button boton1;
    Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               startActivity(new Intent(MainActivity.this, Main.class));
           }
        });

        boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Main.class));
            }
        });

        boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Third.class));
            }
        });
    }
}