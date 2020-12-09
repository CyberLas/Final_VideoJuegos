package com.example.poke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.view.View;
import com.squareup.picasso.Picasso;

public class Main extends AppCompatActivity {
    private TextView textViewResult;
    Button boton;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boton = (Button) findViewById(R.id.texto1);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Main.this, Detalles.class));
            }
        });

        imageView = (ImageView) findViewById(R.id.imagen1);
        imageView1 = (ImageView) findViewById(R.id.imagen2);

        textViewResult =findViewById(R.id.textView12);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        imageView2 = (ImageView) findViewById(R.id.imagen3);
        imageView3 = (ImageView) findViewById(R.id.imagen4);
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Pokemon>> call = jsonPlaceHolderApi.getPokemons();
        imageView4 = (ImageView) findViewById(R.id.imagen5);

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code : " + response.code());
                    return;
                }
                int i=0;
                List<Pokemon> pokemons = response.body();
                for (Pokemon pokemon : pokemons) {
                    String content = "";
                    content += "Nombre del Pokemon : " + pokemon.getNombre() + "\n" + "Tipo de Pokemon    : " + pokemon.getTipo() + "\n\n\n\n\n\n";
                    textViewResult.append(content);
                    if(i == 0) Picasso.get().load(pokemon.getImagen()).resize(100, 100).into(imageView);
                    if(i == 1) Picasso.get().load(pokemon.getImagen()).resize(100, 100).into(imageView1);
                    if(i == 2) Picasso.get().load(pokemon.getImagen()).resize(100, 100).into(imageView2);
                    if(i == 3) Picasso.get().load(pokemon.getImagen()).resize(100, 100).into(imageView3);
                    if(i == 4) Picasso.get().load(pokemon.getImagen()).resize(100, 100).into(imageView4);
                    i++;
                }
            }
            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}