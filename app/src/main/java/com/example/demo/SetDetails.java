package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.Data.MyDbHandler;

public class SetDetails extends AppCompatActivity {
    EditText editText, editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_details);
        getSupportActionBar().setTitle("Add Fruits");
        editText=findViewById(R.id.editTextTextPersonName);
        editText1=findViewById(R.id.editTextNumberSigned);
    }

    public void addItem(View view) {
        MyDbHandler dbHandler = new MyDbHandler(SetDetails.this);
        Fruit fruit=new Fruit();
        fruit.setName(editText.getText().toString());
        fruit.setCount(Integer.parseInt(editText1.getText().toString()));
        dbHandler.addItem(fruit);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }
}