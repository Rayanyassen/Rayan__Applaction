package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import data.AppDataBase;
import data.SubjectTable.MySubject;
import data.SubjectTable.MySubjectQuery;

public class AddTaskActivty extends AppCompatActivity {
    private TextInputEditText etshort_title;
    private TextInputEditText et_Text;
    private Button btnSave;
    private Button BTNCancel;
    private TextView tvImpoertance;
    private SeekBar skbrImportance;
    private TextView textview3;
    private AutoCompleteTextView autoEtSubj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_activty);
        autoEtSubj = findViewById(R.id.autoEtSubj);
        etshort_title = findViewById(R.id.etshort_title);
        et_Text = findViewById(R.id.et_Text);
        btnSave = findViewById(R.id.btnSave);
        BTNCancel = findViewById(R.id.BTNCancel);
        tvImpoertance = findViewById(R.id.tvImpoertance);
        skbrImportance = findViewById(R.id.skbrImportance);
        initAutoEtSubjects();//دالة لاستخراج القيم وعرضها بالحقل السابق


    }

    /**
     * استخراج اسماء المواضيع من جدول المواضيع وعرضه بالحقل من نوع
     * AutoCompleteTextView
     * "طريقه التعامل معه شبيه بالسبنر"
     */
    private void initAutoEtSubjects() {
        //مؤشر لقاعدة البيانات
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
        //مؤشر لواجهه استعلامات جدول المواضيع
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //مصدر معطيات : استخراج جميع المواضيع من الجداول
        List<MySubject> allSubject = subjectQuery.getAll();
        //تجهيز الوسيط
        ArrayAdapter<MySubject>adapter=new ArrayAdapter<MySubject>(this, android.R.layout.simple_dropdown_item_1line);
        adapter.addAll(allSubject);//اضافه جميع المعطيات للوسيط
        autoEtSubj.setAdapter(adapter);// ربط الحقل بالوسيط
        //معالجة حدث لعرض المواضيع عند الضغط على الحقل
        autoEtSubj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoEtSubj.showDropDown();
            }
        });

    }
        private void checkSaveandCancel ()
        {
            boolean isAllOK = true;
            String short_title = etshort_title.getText().toString();
            String Text = et_Text.getText().toString();
            String importance = tvImpoertance.getText().toString();
            if (short_title.length() < 8 || short_title.contains(" ") == true) {

                isAllOK = false;
                etshort_title.setError("Wrong short_title");
            }
            if (Text.length() < 8 || Text.contains(" ") == true) {

                isAllOK = false;
                et_Text.setError("Wrong text");
            }

            if (importance.length() < 8 || importance.contains(" ") == true) {

                isAllOK = false;
                tvImpoertance.setError("Wrong importance");
            }


            if (isAllOK) {
                Toast.makeText(this, "All OK", Toast.LENGTH_SHORT).show();

                private void checkShortTitleAndText()
                {

                    boolean isAllOk=true; // يحوي نتيجة فحص الحقول ان كانت سليمة

                    String shortTitle=etshorttitle.getText().toString();
                    String text=ettext.getText().toString();
                    String whichsubj=autoETsubj.getText().toString();


                    int importancee=skbrlimportance.getProgress();


                    if (shortTitle.length()<1)
                    {
                        isAllOk=false;
                        etshorttitle.setError("short title is empty");
                    }

                    if (text.length()<1)
                    {
                        isAllOk=false;
                        ettext.setError("text is empty");
                    }
                    if (whichsubj.length()<1)
                    {
                        isAllOk=false;
                        autoETsubj.setError("you didn't chose the subject");

                    }

                    if (isAllOk)
                    {
                        Toast.makeText(this,"All ok",Toast.LENGTH_SHORT).show();
                        AppDataBase db=AppDataBase.getDB(getApplicationContext());
                        MysubjectQuery subjectQuery=db.getMySubjectQuery();


                        if (subjectQuery.checkSubject(whichsubj)==null) // فحص هل الموضوع من قبل بالجدول
                        {
                            //بناء موضوع جديد واضافته
                            Mysubject subject=new Mysubject();
                            subject.title=whichsubj;
                            subjectQuery.insertsubject(subject);
                        }
                        //استخراج id الموضوع لأننا بحاجة لرقمه التسلسلي

                        Mysubject subject= subjectQuery.checkSubject(whichsubj);


                        Mytask task=new Mytask();
                        task.importance=importancee;
                        task.text=text;
                        task.shortTitle=shortTitle;
                        task.subid=subject.getKeyid();//تحديد رقم الموضوع للمهة
                        db.getMyTaskQuery().insertTask(task);//اضافة المهمة للجدول
                        finish();

                    }

            }



        }
    public void onclickSAVE(View v)
    {
        checkSaveandCancel();
        Intent i= new Intent(AddTaskActivty.this,MainActivity2.class);
        startActivity(i);
        finish();
    }
    public void onclickCancel(View v){
        Intent i= new Intent(AddTaskActivty.this,MainActivity2.class);
        startActivity(i);
        finish();
    }




}


