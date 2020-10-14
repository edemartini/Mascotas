package com.edemartini.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializaListaMascotas();

        inicializaAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, MascotasRankeadas.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void inicializaAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.alegre, "Alegre"));
        mascotas.add(new Mascota(R.drawable.bonita, "Bonita"));
        mascotas.add(new Mascota(R.drawable.cazador, "Cazador"));
        mascotas.add(new Mascota(R.drawable.guardian, "Guardián"));
        mascotas.add(new Mascota(R.drawable.jugueton, "Juguetón"));
        mascotas.add(new Mascota(R.drawable.manchita, "Manchita"));
        mascotas.add(new Mascota(R.drawable.simpatico, "Simpatico"));
        mascotas.add(new Mascota(R.drawable.tranquila, "Tranquila"));
        mascotas.add(new Mascota(R.drawable.travieso, "Travieso"));
        mascotas.add(new Mascota(R.drawable.triston, "Tristón"));
    }

}