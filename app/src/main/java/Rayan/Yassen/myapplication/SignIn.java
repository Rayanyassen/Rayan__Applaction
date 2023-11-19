package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
public class SignIn extends AppCompatActivity {
    private TextInputEditText Et_E_mail;
    private TextInputEditText Et_Password;
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

    public void onclickbtn_SignUp(View v)
    {
        Intent i= new Intent(SignIn.this, Sign_up.class);
        startActivity(i);
        //to close current activity
        finish();
    }



    private void checkEmailPassw() {
        boolean isAllok = true; //يفحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String email = Et_E_mail.getText().toString();
        //استخراج نص كلمه المرور
        String password = Et_Password.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@") == false) {
            //تعديل المتغير ليدل على ان الفحص يهطي نتيجه خاطئه
            isAllok = false;
            // عرض ملاحظه خطا على الشاشه داخل حقل البريد
            Et_E_mail.setError("Wrong Email");

        }if(password.length()< 8||password.contains("")==true){
            isAllok=false;
            Et_Password.setError("Wrong Password");

        }
        if(isAllok){
            Toast.makeText(this,"All Ok" , Toast.LENGTH_SHORT).show();
        }
    }
    public void onclickbtn_signIn(View v)
    {
        checkEmailPassw();
        Intent i= new Intent(SignIn.this,MainActivity2.class);
        startActivity(i);
        //to close current activity
        finish();
    }
    }


