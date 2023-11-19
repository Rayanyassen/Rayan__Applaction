package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import data.AppDataBase;
import data.usersTable.myUsersQuery;

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
        //استخراج نص اعادة كلمه المرور
        String repassword = ETrepassword.getText().toString();
        // استخراج نص من رقم هاتف
        String phone = ETphone.getText().toString();
        //استخراج نص لأسمك
        String name = ETname.getText().toString();

        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@") == false) {
            //تعديل المتغير ليدل على ان الفحص يهطي نتيجه خاطئه
            isAllok = false;
            // عرض ملاحظه خطا على الشاشه داخل حقل البريد
            Et_emailsignup.setError("Wrong Email");

        }
        if (password.length() < 8 && password.length() > 20 || password.contains("") == true) {
            isAllok = false;
            ETpassword.setError("Password between 8 - 20 letters");
        }
        if (!repassword.equals(password)) {
            isAllok = false;
            ETrepassword.setError("should be the same password");
        }


        if (phone.length() > 10 || phone.contains("") == true) {
            isAllok = false;
            ETphone.setError("phone number is 10 numbers");

        }


        if (isAllok) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة وارجاع مؤشر عليها1
            AppDataBase db=AppDataBase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول2
            myUsersQuery usersQuery=db.getMyUserQuery();
            //اتدعاء العملية التي تنفذ الاستعلام الذي يفحص البريد و كلمة المرور ويعيد كائنا ان كان موجودا او ان لم يكن موجود null
        }

    }
    public void onclickBTNSAVE(View V)
    {
        checkEmailPassw();



    }
    public void onclickBTNCancel(View v){
        Intent i = new Intent(Sign_up.this, SignIn.class);
        startActivity(i);
        //to close current activity
        finish();
    }

}