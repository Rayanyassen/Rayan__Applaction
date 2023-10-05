package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import data.AppDataBase;
import data.SubjectTable.MySubject;
import data.SubjectTable.MySubjectQuery;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("yassen", "onCreate: ");
        Toast.makeText(this, "onCreate:",Toast.LENGTH_SHORT).show();
        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
        AppDataBase db= AppDataBase.getDB(getApplicationContext()) ;
        //مؤشر لكائن عمليات لجدول  2
        MySubjectQuery subjectQuery=db.getMySubjectQuery();
        //بناء كائن من نوع الجدول و تحديد قيم الصفات 3
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2= new MySubject();
        s2.Title="Computers";
        //اضافه كائن للجدول 4
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);
        //فحص هل تم  حفظ ما سبق 5
        // استخراج وطباعهة جميع معطيات الجدول المواضيع
        List<MySubject> allSubjects=subjectQuery.getAll();
        for (MySubject s: allSubjects) {
            Log.d("rayan",s.Title);
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("yassen", "onRestart: ");
        Toast.makeText(this, "onRestart:",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("yassen", "onResume: ");
        Toast.makeText(this, "onResume:",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("yassen", "onPause: ");
        Toast.makeText(this, "onPause:",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("yassen", "onStop: ");
        Toast.makeText(this, "onStop:",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("yassen", "onDestroy: ");
        Toast.makeText(this, "onDestroy:",Toast.LENGTH_SHORT).show();
    }


}

