package com.example.poke;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.File;
import java.net.URI;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.support.v4.content.FileProvider.getUriForFile;

public class Third extends AppCompatActivity {
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    ImageView imagen;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        boton = (Button) findViewById(R.id.enviar);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Third.this, MainActivity.class));
            }
        });
    }

    private void createPokemon() {
        Map<String, String> fields = new HashMap<>();
        Call<Pokemon> call = jsonPlaceHolderApi.createPokemon(null);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Pokemon postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getNombre() + "\n";
                content += "User ID: " + postResponse.getTipo() + "\n";
                content += "Title: " + postResponse.getLatitude() + "\n";
                content += "Text: " + postResponse.getLongitude() + "\n\n";
                textViewResult.setText(content);
            }
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"), 10);
    }
}