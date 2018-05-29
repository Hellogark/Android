package com.example.supdude.appcomidita;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptadorLocal extends RecyclerView.Adapter<AdaptadorLocal.ViewHolder> {
    private ArrayList<datosLocal> data = new ArrayList<>();
    private DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference refLocales = rootRef.child("Locales");
    private Context mContext;
    String opcion;

    public AdaptadorLocal(Context context,ArrayList<datosLocal> nombreDir) {
        data=nombreDir;
        mContext=context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.distribuyelocales,parent,false);

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final datosLocal dLocal= data.get(position);
        holder.nombre.setText(dLocal.nombreLocal);
        holder.direccion.setText(dLocal.direccion);
        holder.rowlocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, data.get(position).getNombreLocal(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, local.class);
                i.putExtra("position",dLocal);
                String nombreLocal= holder.nombre.getText().toString();
                i.putExtra("nombreL",nombreLocal);
                mContext.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView nombre,direccion;
        RelativeLayout rowlocal;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.txtNombreLocal);
            direccion = itemView.findViewById(R.id.txtDireccion);
            rowlocal = itemView.findViewById(R.id.rowLocal);
        }
    }


    }

