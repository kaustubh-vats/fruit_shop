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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout, relativeLayout1;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login");
        relativeLayout=findViewById(R.id.animRelative);
        relativeLayout1=findViewById(R.id.relativeLayout);
        username=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextTextPassword);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.slideleft_anim);
        relativeLayout1.startAnimation(animation1);
    }
    public void login(View view){
        if(username.getText().toString().equals("admin@fruits.com") && password.getText().toString().equals("PASSWORD@123"))
        {
            Intent intent = new Intent(this, SetItems.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        else{
            MyDbHandler loginDbHandler = new MyDbHandler(this);
            List<LoginModel> users = loginDbHandler.getAllUsers();
            LoginModel loginModel=new LoginModel();
            loginModel.setUsername(username.getText().toString());
            loginModel.setPassword(password.getText().toString());
            boolean flag = true;
            for(LoginModel loginModel1:users)
            {
                if(loginModel1.getUsername().equals(loginModel.getUsername()))
                {
                    if(loginModel1.getPassword().equals(loginModel.getPassword()))
                    {
                        Intent intent = new Intent(this, UserDisplay.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                    flag=false;
                }
            }
            if(flag){
                Toast.makeText(this, "Wrong details", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void signup(View view) {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.slide_up);
        animation.setDuration(1000);
        relativeLayout.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                relativeLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void Forgot(View view) {
        Toast.makeText(this, "This feature is not available in simple database app", Toast.LENGTH_SHORT).show();
    }
}