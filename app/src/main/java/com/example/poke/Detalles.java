package com.example.poke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.ImageView;
import android.view.View;
import com.squareup.picasso.Picasso;


public class Detalles extends AppCompatActivity {
    Button boton;
    ImageView imageView;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        boton = (Button) findViewById(R.id.button3);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Detalles.this, Ubication.class));
            }
        });

        textViewResult =findViewById(R.id.textView123);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Pokemon>> call = jsonPlaceHolderApi.getPokemons();

        imageView = (ImageView) findViewById(R.id.imageView123);

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                int a = 0;
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code : " + response.code());
                    return;
                }
                List<Pokemon> pokemons = response.body();
                for (Pokemon pokemon : pokemons) {
                    if(a == 0){
                        String content = "";
                        content += "\n\n\n Nombre : " + pokemon.getNombre() + "\n\n" + "Tipo : " + pokemon.getTipo() + "\n\n";
                        textViewResult.append(content);
                        Picasso.get()
                                .load("https://upn.lumenes.tk/pokemons/" + pokemon.getImagen())
                                .into(imageView);
                    }
                    a++;
                }
            }
            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

}