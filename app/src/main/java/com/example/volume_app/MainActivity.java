package com.example.volume_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<shape> shapesArrayList;
    MyCustomAdaptor myCustomAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);
        shapesArrayList = new ArrayList<>();
        shape s1 = new shape(R.drawable.sphere, "Sphere");
        shape s2 = new shape(R.drawable.cube, "Cube");
        shape s3 = new shape(R.drawable.cylinder, "Cylinder");
        shape s4 = new shape(R.drawable.prism, "Prism");

        shapesArrayList.add(s1);
        shapesArrayList.add(s2);
        shapesArrayList.add(s3);
        shapesArrayList.add(s4);


        MyCustomAdaptor adapter = new MyCustomAdaptor(this, shapesArrayList);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), sphere.class);
                startActivity(i);
            }

            });
        }
}