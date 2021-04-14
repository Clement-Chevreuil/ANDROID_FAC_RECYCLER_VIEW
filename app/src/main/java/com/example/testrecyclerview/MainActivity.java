package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    private ArrayList<Planete> getDataSource() {
        ArrayList results = new ArrayList<Planete>();
        //for (int index = 0; index < 20; index++) {
         //   Planete obj = new Planete("Texte principal " + index,"Texte auxiliaire " + index);
         //   results.add(index, obj);
        //}

        Planete terre = new Planete("Terre", "6 371 km", R.drawable.terre);
        Planete mars = new Planete("Mars", "3 389,5 km", R.drawable.mars);
        Planete neptune = new Planete("Neptune", "24 622 km", R.drawable.neptune);
        Planete saturne  = new Planete("Saturne", "58 232 km", R.drawable.saturne);

        results.add(terre);
        results.add(mars);
        results.add(neptune);
        results.add(saturne);

        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }
}