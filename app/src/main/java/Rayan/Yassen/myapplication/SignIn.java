package Rayan.Yassen.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import data.AppDataBase;
import data.usersTable.myUsersQuery;
import data.usersTable.myusers;

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
    private void checkEmailPassw_FB() {
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

        }
        if(password.length()< 8||password.contains(" ")==true)
        {
            isAllok=false;
            Et_Password.setError("Wrong Password");

        }


    }

    private void checkEmailPassw_FB2() {
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

        }
        if(password.length()< 8||password.contains(" ")==true)
        {
            isAllok=false;
            Et_Password.setError("Wrong Password");

        }
        if(isAllok){
            //עצם לביצוע רישום كائن لعملية التسجيل
            FirebaseAuth auth=FirebaseAuth.getInstance();
            //כניסה לחשבון בעזרת מיל ן סיסמא
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {//אם הפעולה הצליחה
                        Toast.makeText(SignIn.this, "Signing up Succeeded", Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        Toast.makeText(SignIn.this, "Signing up failed", Toast.LENGTH_SHORT).show();
                        Et_E_mail.setError(task.getException().getMessage());//הצגת הודעת השגיאה שהקבלה מהענן
                    }
                }
            });
        }


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

        }
        if(password.length()< 8||password.contains(" ")==true)
        {
            isAllok=false;
            Et_Password.setError("Wrong Password");

        }
        if(isAllok){

            //بناء قاعدة وارجاع مؤشر عليها1
            AppDataBase db=AppDataBase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول2
            myUsersQuery usersQuery=db.getMyUserQuery();
            //استدعاء العملية التي تنفذ الاستعلام الذي يفحص البريد و كلمة المرور ويعيد كائنا ان كان موجودا او ان لم يكن موجود null
            myusers myUser=usersQuery.checkEmailPassw(email,password);
            if(myUser==null)//هل لا يوجد كائن حسب الايميل والباسورد
            {
                Toast.makeText(this,"Wrong Email or Password ", Toast.LENGTH_LONG).show();

            }
            else
            {//ان كان هنالك حساب الايميل و الباسورد ننتقل الى الشاشه الرئيسية
                Toast.makeText(this,"All Ok" , Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SignIn.this,MainActivity2.class);
                startActivity(i);
                finish();
            }
        }
    }
    public void onclickbtn_signIn(View v)
    {
        checkEmailPassw();


    }
    }


