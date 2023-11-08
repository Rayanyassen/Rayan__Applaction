package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }
    public void onclickGo1(View v)
    {
        Intent i= new Intent(SignIn.this, Sign_up.class);
        startActivity(i);
        //to close current activity
        finish();
    }


    public void onclickGo2(View v)
    {
        Intent i= new Intent(SignIn.this,MainActivity2.class);
        startActivity(i);
        //to close current activity
        finish();
    }
}


