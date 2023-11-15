package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Sign_up extends AppCompatActivity {
    private TextInputEditText Et_emailsignup;
    private TextInputEditText ETpassword;
    private TextInputEditText ETrepassword;
    private TextInputEditText ETname;
    private TextInputEditText ETphone;
    private Button btnsavesignup;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Et_emailsignup = findViewById(R.id.Et_emailsignup);
        ETpassword = findViewById(R.id.ETpassword);
        ETrepassword = findViewById(R.id.ETrepassword);
        ETname = findViewById(R.id.ETname);
        ETphone = findViewById(R.id.ETphone);
        btnsavesignup = findViewById(R.id.btnsavesignup);
        btnCancel = findViewById(R.id.btnCancel);
    }



    private void checkEmailPassw() {
        boolean isAllok = true; //يفحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String email = Et_emailsignup.getText().toString();
        //استخراج نص كلمه المرور
        String password = ETpassword.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@") == false) {
            //تعديل المتغير ليدل على ان الفحص يهطي نتيجه خاطئه
            isAllok = false;
            // عرض ملاحظه خطا على الشاشه داخل حقل البريد
            Et_emailsignup.setError("Wrong Email");

        }
        if (password.length() < 8 && password.length() >20  || password.contains("") == true) {
            isAllok = false;
            ETpassword.setError("Password between 8 - 20 letters");

        }
        if (isAllok) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }
    }
    public void onclickBTNSAVE(View v) {
        if(checkEmailPassw()){
            Intent i = new Intent(Sign_up.this, SignIn.class);
            startActivity(i);
            //to close current activity
            finish();
        }

    }
}