package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;

import com.example.demo.Data.MyDbHandler;
import com.example.demo.RecyclerAdapters.AdminRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class SetItems extends AppCompatActivity {
    RecyclerView recyclerView;
    AdminRecycleAdapter adminRecycleAdapter;
    MyDbHandler myDbHandler;
    List<Fruit> fruitList;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_items);
        getSupportActionBar().setTitle("Admin Panel");
        myDbHandler = new MyDbHandler(this);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fruitList = myDbHandler.getAllFruit();
        adminRecycleAdapter = new AdminRecycleAdapter(this,fruitList);
        recyclerView.setAdapter(adminRecycleAdapter);
    }

    public void addFruit(View view) {
        Intent intent = new Intent(SetItems.this,SetDetails.class);
        startActivity(intent);
    }
}