package com.example.gridmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        //created new array list..
        recyclerDataArrayList = new ArrayList<>();

        //added data to array list
        recyclerDataArrayList.add(new RecyclerData("DSA", R.drawable.ic_gfglogo, 1));
        recyclerDataArrayList.add(new RecyclerData("JAVA", R.drawable.ic_gfglogo, 1));
        recyclerDataArrayList.add(new RecyclerData("C++", R.drawable.ic_gfglogo, 2));
        recyclerDataArrayList.add(new RecyclerData("Python", R.drawable.ic_gfglogo, 1));
        recyclerDataArrayList.add(new RecyclerData("Node Js", R.drawable.ic_gfglogo,2 ));
        recyclerDataArrayList.add(new RecyclerData("Python", R.drawable.ic_gfglogo, 1));
        recyclerDataArrayList.add(new RecyclerData("Python", R.drawable.ic_gfglogo, 1));
        recyclerDataArrayList.add(new RecyclerData("Python", R.drawable.ic_gfglogo, 1));

        //added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList,this);
        //setting grid layout manager to implement grid view.
        // in this method '2' represents number of colums to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
               RecyclerData data =  recyclerDataArrayList.get(position);
               return data.getSpan();
            }
        });
        //at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        GridSpace space = new GridSpace(60 , 10);
        recyclerView.addItemDecoration(space);
        recyclerView.setAdapter(adapter);

    }
}