package Rayan.Yassen.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class splashscreen extends AppCompatActivity {
    //spnr1 تعريف صفه الكائن المرئي
    private Spinner spnrSubject;
    private TextView ET_Text;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreenactivty);
        ET_Text= findViewById(R.id.ET_Text);

        Log.d("yassen", "onCreate: ");
        Toast.makeText(this, "onCreate:", Toast.LENGTH_SHORT).show();
//        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
//        AppDataBase db = AppDataBase.getDB(getApplicationContext());
//        //مؤشر لكائن عمليات لجدول  2
//        MySubjectQuery subjectQuery = db.getMySubjectQuery();
//        //بناء كائن من نوع الجدول و تحديد قيم الصفات 3
//        MySubject s1 = new MySubject();
//        s1.setTitle("Math");
//        MySubject s2 = new MySubject();
//        s2.Title = "Computers";
//        //اضافه كائن للجدول 4
//        subjectQuery.insert(s1);
//        subjectQuery.insert(s2);
//        //فحص هل تم  حفظ ما سبق 5
//        // استخراج وطباعة جميع معطيات الجدول المواضيع
//        List<MySubject> allSubjects = subjectQuery.getAll();
//        for (MySubject s : allSubjects) {
//            Log.d("rayan", s.Title);
//            Toast.makeText(this, "OnCreate:", Toast.LENGTH_SHORT).show();
//        }
        Handler h=new Handler();
        Runnable r=new Runnable() {

            public void run()
            {
                //to open new activity from current to next
                Intent i= new Intent(splashscreen.this, SignIn.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r,3000);


}




    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("yassen", "");
        Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("yassen", " ");
        Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("yassen", " ");
        Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("yassen", "");
        Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("yassen", " ");
        Toast.makeText(this, "",Toast.LENGTH_SHORT).show();
    }


}

