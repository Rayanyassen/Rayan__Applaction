package Rayan.Yassen.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import data.AppDataBase;
import data.SubjectTable.MySubject;
import data.SubjectTable.MySubjectQuery;


public class        MainActivity extends AppCompatActivity {
        //spnr1 تعريف صفة للكائن المرئي
        private Spinner spnrSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spnr2 وضع المؤشر  الصفة  على الكائن المرئي الموجود بواسطة المستعمل
        spnrSubject= findViewById(R.id.spnrSubject);

        //spnr3 بناء  االوسيط وتحديد واجهة تنسيق لمعطى واحد
        ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item);
        //spnr4 data source (ممكن ان يكون قائمه  من قاعده بيانات مثلا) مصدر معطيات
        String[] ar={"Math","CS","PHs","Arb","Eng"};
        //spnr5 تحديد المعطيات للوسيط
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter.addAll(ar);
        //spnr6
        spnrSubject.setAdapter(adapter);

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
        // استخراج وطباعة جميع معطيات الجدول المواضيع
        List<MySubject> allSubjects=subjectQuery.getAll();
        for (MySubject s: allSubjects) {
            Log.d("rayan",s.Title);
            Toast.makeText(this,"OnCreate:",Toast.LENGTH_SHORT).show();       }
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

