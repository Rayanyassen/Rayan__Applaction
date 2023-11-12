package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {
    private TextInputLayout Et_E_mail;
    private TextInputLayout Et_Password;
    private Button btn_SignUp;
    private Button btn_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Et_E_mail=findViewById(R.id.Et_E_mail);
        Et_Password=findViewById(R.id.Et_Password);
        btn_SignUp=findViewById(R.id.btn_SignUp);
        btn_signIn=findViewById(R.id.btn_signIn);
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


