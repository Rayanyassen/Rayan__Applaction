package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import data.AppDataBase;
import data.SubjectTable.MySubject;
import data.SubjectTable.MySubjectQuery;
import data.myTasksTable.MyTasks;
import data.myTasksTable.MyTasksQuery;

public class MainActivity2 extends AppCompatActivity {
    private FloatingActionButton fabAdd;
    private SearchView srchV;
    private Spinner spnrSubject2;
    private ListView lstvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent i = new Intent(MainActivity2.this, AddTaskActivty.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        });


        srchV = findViewById(R.id.srchV);
        spnrSubject2 = findViewById(R.id.spnrSubject2);
        lstvTasks = findViewById(R.id.lstvTasks);

    }
    private void initSubjectSpnr () {
        AppDataBase db = AppDataBase.getDB(getApplicationContext());//بناء قاعدة بيانات
        MySubjectQuery subjectQuery = db.getMySubjectQuery();//عمليات جدول المواضيع
        List<MySubject> allSubject = subjectQuery.getAll();//استخراج جميع المواضيع
        //تجهيز الوسيط
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        subjectAdapter.add("All");//ستظهر اولا بالسبنر تعني عرض جميع المهمات
        for (MySubject subject : allSubject) {
            //اضافه المواضيع للوسيط
            subjectAdapter.add(subject.getTitle());
        }
        spnrSubject2.setAdapter(subjectAdapter);

    }
    /**
     * تجهيز قائمه جميع المهمات وعرضها ب list View
     */
    private void initiAlllistView(){
        AppDataBase db=AppDataBase.getDB(getApplicationContext());
        MyTasksQuery tasksQuery=db.getMyTaskQuery();
        List<MyTasks>allTasks=tasksQuery.getallTasks();
        ArrayAdapter<MyTasks>tasksArrayAdapter=new ArrayAdapter<MyTasks>(this, android.R.layout.simple_dropdown_item_1line);
        tasksArrayAdapter.addAll(allTasks);
        lstvTasks.setAdapter(tasksArrayAdapter);
    }
    /**
     * تجهيز قائمه المهمات حسب رقم الموضوع
     * @param key_id رقم الموضوع
     */
//    private void initListViewBySubjId(Long key_id){
//        AppDataBase db=AppDataBase.getDB(getApplicationContext());
//        MyTasksQuery tasksQuery =db.getMyTaskQuery();
//        //يجب اضافه عملية تعيد جميع المهمات حسب رقم الموضوع
//        List<MyTasks> AllTasks=tasksQuery.getTasksBySubjId(key_id);
//        ArrayAdapter<MyTasks>tasksArrayAdapter=new ArrayAdapter<MyTasks>(this,android.R.layout.simple_dropdown_item_1line);
//        tasksArrayAdapter.addAll(AllTasks);
//        lstvTasks.setAdapter(tasksArrayAdapter);
//        spnrSubject2.setAdapter(spnrSubject2);
//         public void onMenuItemSelected(AdapterView<>adapterView,View view,int i,long l){
//             //استخراج  الموضوع حسب رقم الترتيبي
//            String item = spnrSubject2.
//        }
//    }
    /**
     *
     * عملية تجهيز السبنر بالمواضيع
     */
    @Override
    protected void onResume() {
        super.onResume();
        initSubjectSpnr();
        initiAlllistView();


    }
}
