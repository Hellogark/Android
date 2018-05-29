package com.example.supdude.appcomidita;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class listaLocales extends AppCompatActivity implements Serializable, View.OnClickListener {

    ArrayList<datosLocal> lista;
    TextView tipoComida;
    ImageView mapa, atras;
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference refLocales = rootRef.child("Locales");
    AdaptadorLocal adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locales);

        tipoComida = findViewById(R.id.txtComida);
        mapa =findViewById(R.id.imagenMapa);
        mapa.setOnClickListener(this);
        atras=findViewById(R.id.atrasListaL);
        atras.setOnClickListener(this);


        Intent i = getIntent();
        String nombreTipo= i.getStringExtra("tipoComida");
        tipoComida.setText(nombreTipo);
       // llenarLista();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lista= new ArrayList<datosLocal>();




            refLocales.orderByChild(nombreTipo).equalTo(nombreTipo).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    lista.removeAll(lista);
                    for (DataSnapshot ds : dataSnapshot.getChildren()){
                        String nl= ds.child("Nombre").getValue(String.class);
                        String dir=ds.child("Dirección").getValue(String.class);
                        datosLocal dat= new datosLocal(nl,dir);
                        lista.add(dat);
                        recyclerView.setAdapter(adaptador);
                        adaptador= new AdaptadorLocal(listaLocales.this,lista);



                    }adaptador.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        //VERTICAL
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //HORIZONTAL
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this));

    }

    private void llenar(ArrayList lista) {
        int [] arregloBandera = {R.drawable.cena};
        lista.add(new datosLocal("Little Caesars", "www.littlecaesars.com",
                "Enrique segoviano", R.drawable.littlecaesars, "8129000", "Lunes-Domingo 11AM-10PM"));
        lista.add(new datosLocal("Local2", "uno@gmail.com", "Enrique segoviano2","111111"));
        lista.add(new datosLocal("Local3", "uno@gmail.com", "Enrique segoviano3","111111"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imagenMapa:
                if(isServicesOK()) {
                    startActivity(new Intent(listaLocales.this, mapaLocales.class));
                }
                break;
            case R.id.atrasListaL:
                finish();
                break;
        }
    }
    public boolean isServicesOK(){


        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests

            return true;


        }return false;
    }
}
