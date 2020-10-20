package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demo.Data.MyDbHandler;
import com.example.demo.RecyclerAdapters.AdminRecycleAdapter;
import com.example.demo.RecyclerAdapters.UserRecycleAdapter;

import java.util.List;

public class UserDisplay extends AppCompatActivity {
    RecyclerView recyclerView;
    UserRecycleAdapter userRecycleAdapter;
    MyDbHandler myDbHandler;
    List<Fruit> fruitList;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_display);
        getSupportActionBar().setTitle("Fruit Shop");
        myDbHandler = new MyDbHandler(this);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fruitList = myDbHandler.getAllFruit();
        userRecycleAdapter = new UserRecycleAdapter(this ,fruitList);
        recyclerView.setAdapter(userRecycleAdapter);
    }

    public void buyItnow(View view) {
        for(Fruit fruit:fruitList){
            MyDbHandler dbHandler = new MyDbHandler(this);
            dbHandler.updateFruits(fruit);
            Toast.makeText(this, "Item Purchased", Toast.LENGTH_SHORT).show();
            userRecycleAdapter.notifyDataSetChanged();
        }
    }
}