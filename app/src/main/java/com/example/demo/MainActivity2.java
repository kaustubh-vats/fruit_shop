package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.demo.Data.LoginDbHandler;
import com.example.demo.Data.MyDbHandler;

public class MainActivity2 extends AppCompatActivity {
    RelativeLayout relativeLayout1;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Sign up");
        relativeLayout1=findViewById(R.id.relativeLayout1);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.slideleft_anim);
        relativeLayout1.startAnimation(animation1);
        username=findViewById(R.id.editTextTextEmailAddress2);
        password=findViewById(R.id.editTextTextPassword2);
    }
    public void signIn(View view){
        MyDbHandler loginDbHandler = new MyDbHandler(this);
        LoginModel user = new LoginModel();
        if(username.getText().toString().contains("admin")){
            Toast.makeText(this, "Your username should not contain admin", Toast.LENGTH_SHORT).show();
            return;
        }
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        loginDbHandler.addUser(user);
        Toast.makeText(this, "User Created Successfully... Please Login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}