package com.example.testrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonRecyclerViewAdapter extends RecyclerView.Adapter<MonRecyclerViewAdapter.ConteneurDeDonnee>
{
    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;
    private ArrayList<Planete> planetes;

    public MonRecyclerViewAdapter(ArrayList<Planete> planetes)
    {
        this.planetes = planetes;
    }

    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ConteneurDeDonnee(view);
    }
    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position)
    {
        conteneur.tv_principal.setText(planetes.get(position).getPrincipal());
        conteneur.tv_auxiliaire.setText(planetes.get(position).getAuxiliaire());
        conteneur.tv_image.setImageResource(planetes.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return planetes.size();
    }


    public class ConteneurDeDonnee extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView tv_principal;
        TextView tv_auxiliaire;
        ImageView tv_image;
        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            tv_principal = (TextView) itemView.findViewById(R.id.tv_principal);
            tv_auxiliaire = (TextView) itemView.findViewById(R.id.tv_auxiliaire);
            tv_image = (ImageView) itemView.findViewById(R.id.tv_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
        this.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
    }




}
