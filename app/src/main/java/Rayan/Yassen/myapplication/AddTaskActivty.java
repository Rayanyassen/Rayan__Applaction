package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
            }


        }


    }


