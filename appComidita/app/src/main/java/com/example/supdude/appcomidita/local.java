package com.example.supdude.appcomidita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class local extends AppCompatActivity implements View.OnClickListener {
    ArrayList<datosMenu> lista;
    ArrayList <datosLocal> horas;
    TextView nombreLocal;
    static TextView presupuesto;
    TextView direc;
    TextView catego;
    TextView tel;
    TextView sitio;
    TextView semana;
    Spinner horario;
    ImageView imagenLocal, mapa,atrasLocal;
    datosLocal dL,hor;
    coordenadas latLon;
    String local = "";
    double total = 0.0;
    TabHost tabs;
    Integer[] enteredNumber = new Integer[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        tabs = findViewById(R.id.tabhost);

        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Información");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Menú");
        tabs.addTab(spec);
        semana=findViewById(R.id.txt_semana);
        nombreLocal = findViewById(R.id.txtLocal);
        imagenLocal = findViewById(R.id.imgImagenLocal);
        presupuesto = findViewById(R.id.txtTotal);
        mapa = findViewById(R.id.imagenMapa);
        mapa.setOnClickListener(this);
        atrasLocal=findViewById(R.id.atr_InfoLocal);
        atrasLocal.setOnClickListener(this);
        direc = findViewById(R.id.txt_Dir);
        horario = findViewById(R.id.sp_Horario);

        catego = findViewById(R.id.editCatego);
        tel = findViewById(R.id.editTelefono);
        tel.setCompoundDrawables(getResources().getDrawable(R.drawable.tel), null, null, null);
        sitio = findViewById(R.id.editSitio);
        final Intent intent = getIntent();
        sitio.setCompoundDrawables(getResources().getDrawable(R.drawable.world), null, null, null);
      /*  if (getIntent().hasExtra("nombreL")) {
            lista = new ArrayList<datosMenu>();
            final String nombreLocal = intent.getStringExtra("nombreL");
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            final DatabaseReference refNom = (DatabaseReference) ref.child("Locales").orderByChild("Nombre").equalTo(nombreLocal);
            refNom.child("menu").orderByChild("Nombre").equalTo(nombreLocal).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    lista.removeAll(lista);
                    for (DataSnapshot ds1 : dataSnapshot.child("menu").getChildren()) {
            for(DataSnapshot menuChild : dataSnapshot.)

                        String nomPlatillo = ds1.child("menu").getValue(String.class);
                        Toast.makeText(local.this, nomPlatillo, Toast.LENGTH_SHORT).show();
                        String descPlatillo = ds1.child("menu")
                                .child("Descripcion").getValue(String.class);
                        Double precio = ds1.child("menu").
                                child(String.valueOf(i)).child("precio").getValue(Double.class);
                        datosMenu menu = new datosMenu(nomPlatillo, descPlatillo, precio);
                        lista.add(menu);


                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }*/
          obtenerAllData();
            horario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                                                      final String nombreLoc = intent.getStringExtra("nombreL");
                                                      String item = parent.getItemAtPosition(position).toString();
                                                      nombreLocal.setText(nombreLoc);



                                                      DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                                                      final DatabaseReference refNom = ref.child("Locales");
                                                      refNom.orderByChild("Nombre").equalTo(nombreLoc).addValueEventListener(new ValueEventListener() {
                                                          @Override
                                                          public void onDataChange(DataSnapshot dataSnapshot) {
                                                              for(DataSnapshot ds: dataSnapshot.getChildren()){
                                                                  hor = new datosLocal(
                                                                  ds.child("Horario").child("Lunes").getValue(String.class),
                                                                          ds.child("Horario").child("Martes").getValue(String.class),
                                                                          ds.child("Horario").child("Miercoles").getValue(String.class),
                                                                          ds.child("Horario").child("Jueves").getValue(String.class),
                                                                          ds.child("Horario").child("Viernes").getValue(String.class),
                                                                          ds.child("Horario").child("Sabado").getValue(String.class),
                                                                          ds.child("Horario").child("Domingo").getValue(String.class)
                                                                  );
                                                                  horas=new ArrayList<>();
                                                                  horas.add(hor);
                                                                  switch (position) {
                                                                      case 0:
                                                                          semana.setText(horas.get(0).lunes);
                                                                          break;
                                                                      case 1:
                                                                          semana.setText(horas.get(0).martes);
                                                                          break;
                                                                      case 2:
                                                                          semana.setText(horas.get(0).miercoles);
                                                                          break;
                                                                      case 3:
                                                                          semana.setText(horas.get(0).jueves);
                                                                          break;
                                                                      case 4:
                                                                          semana.setText(horas.get(0).viernes);
                                                                          break;
                                                                      case 5:
                                                                          semana.setText(horas.get(0).sabado);
                                                                          break;
                                                                      case 6:
                                                                          semana.setText(horas.get(0).domingo);
                                                                          break;
                                                                  }
                                                              }
                                                          }

                                                          @Override
                                                          public void onCancelled(DatabaseError databaseError) {

                                                          }
                                                      });




                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              } );



        /*Bundle  datos = getIntent().getExtras();
        final datosLocal objeto = (datosLocal)datos.getSerializable("objeto");

        nombreLocal.setText(objeto.getNombreLocal());
        imagenLocal.setImageResource(objeto.getLogo());
        direc.setText(objeto.getDireccion());
        //horario.setText(objeto.getHorario());
        catego.setText(datos.getString("tipoComida"));
        tel.setText(objeto.getTel1());
        sitio.setText(objeto.getSitio());*/

        lista = new ArrayList<>();
        llenar(lista);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setAdapter(new AdaptadorMenu(lista, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                /*total = Double.parseDouble(String.valueOf(presupuesto.getText()));
                total = total + lista.get(position).getPrecio();
                presupuesto.setText(String.valueOf(total));*/

                //presupuesto.setText(String.valueOf(AdaptadorMenu.editWatcher.recibirDato(Double.parseDouble(String.valueOf(presupuesto.getText())),lista.get(position).getPrecio())));

                //Intent i = new Intent(listaLocales.this, local.class);
                //i.putExtra("objeto",  lista.get(position));
                //i.putExtra("posicion", position);
                //startActivity(i);

             /*   cantidad = ((Integer) lista.get(position).getCantidad());
                Toast.makeText(local.this, String.valueOf(cantidad), Toast.LENGTH_SHORT).show();
                total = total + (cantidad * lista.get(position).getPrecio());
                presupuesto.setText(cantidad);*/
            }
        }));
        //VERTICAL
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
public void actualizarValor(){

}
    private void llenar(ArrayList lista) {
        lista.add(new datosMenu("Pizza", "Familiar de 8 trozos", 1.0,0.0 , R.drawable.littlecaesars,0));
        lista.add(new datosMenu("Pizza", "Familiar de 8 trozos", 1.0,0.0 , R.drawable.littlecaesars,0));
        lista.add(new datosMenu("Pizza", "Familiar de 8 trozos", 1.0,0.0 , R.drawable.littlecaesars,0));
        lista.add(new datosMenu("Pizza", "Familiar de 8 trozos", 1.0,0.0 , R.drawable.littlecaesars,0));
    }

    public static void dato(Double t){
        presupuesto.setText(String.valueOf(t));
    }
    public void obtenerAllData() {

        Intent intent=getIntent();
        if (getIntent().hasExtra("nombreL")) {
            lista = new ArrayList<datosMenu>();
            final String nombreLoc = intent.getStringExtra("nombreL");
            nombreLocal.setText(nombreLoc);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            final DatabaseReference refNom = ref.child("Locales");
            refNom.orderByChild("Nombre").equalTo(nombreLoc).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                    dL= new
                            datosLocal(ds.child("Nombre").getValue(String.class),
                            ds.child("Dirección").getValue(String.class),
                            ds.child("Telefono1").getValue(String.class),
                            ds.child("SitioWeb").getValue(String.class),
                            ds.child("Categoria").getValue(String.class)
                            );

                    nombreLocal.setText(dL.nombreLocal);
                    direc.setText(dL.direccion);
                    tel.setText(dL.tel1);
                    catego.setText(dL.categoria);
                    sitio.setText(dL.sitio);

                        mapa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.imagenMapa:
                                    Intent i = new Intent(com.example.supdude.appcomidita.local.this, mapaLocales.class);

                                   i.putExtra("coordenada",dL.nombreLocal);
                                    setResult(RESULT_OK, i);
                                    startActivity(i);
                                    break;
                            }
                        }
                    });
                }

                    }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.atr_InfoLocal:
                startActivity(new Intent(com.example.supdude.appcomidita.local.this,listaLocales.class));



        }
    }
}
