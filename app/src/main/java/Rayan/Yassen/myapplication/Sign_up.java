package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Sign_up extends AppCompatActivity {
    private TextInputLayout Et_emailsignup ;
    private TextInputLayout ETpassword;
    private TextInputLayout ETrepassword;
    private TextInputLayout ETname;
    private TextInputLayout ETphone;
    private Button btnsavesignup;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Et_emailsignup=findViewById(R.id.Et_emailsignup);
        ETpassword=findViewById(R.id.ETpassword);
        ETrepassword=findViewById(R.id.ETrepassword);
        ETname=findViewById(R.id.ETname);
        ETphone=findViewById(R.id.ETphone);
        btnsavesignup=findViewById(R.id.btnsavesignup);
        btnCancel=findViewById(R.id.btnCancel);
    }
    public void onclickGo(View v)
    {
        Intent i= new Intent(Sign_up.this, SignIn.class);
        startActivity(i);
        //to close current activity
        finish();
    }
}