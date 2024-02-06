package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

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


                Intent i=new Intent(MainActivity2.this,AddTaskActivty.class);
                startActivity(i);
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
        spnrSubject2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                // استخراج الموضوع حسب رقم الترتيبي
                String item=subjectAdapter.getItem(i);
                if(item.equals("All")){
                    initiAlllistView();
                }
                else{
                    // استخراج كائن الموضوع الذي اخترناه لاستخراج رقمه id
                    MySubject subject=subjectQuery.checkSubject(item);
                    //استدعاء العمليه التي تجهز القائمه حسب رقم الموضوع  id
                    initListViewBySubjId(subject.getKeyid());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
        lstvTasks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()    {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                showPopUpMenu(view,tasksArrayAdapter.getItem(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        }
        );

    }
    /**
     * تجهيز قائمه المهمات حسب رقم الموضوع
     * @param keyid رقم الموضوع
     */
    private void initListViewBySubjId(long keyid) {
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
        MyTasksQuery tasksQuery = db.getMyTaskQuery();
        //يجب اضافه عملية تعيد جميع المهمات حسب رقم الموضوع
        List<MyTasks> AllTasks = tasksQuery.getTasksBySubjId(keyid);
        ArrayAdapter<MyTasks> tasksArrayAdapter = new ArrayAdapter<MyTasks>(this, android.R.layout.simple_dropdown_item_1line);
        tasksArrayAdapter.addAll(AllTasks);
        lstvTasks.setAdapter(tasksArrayAdapter);
    }


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



    @Override//بناء القائمه
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if (item.getItemId() == R.id.itmsetting) {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(MainActivity2.this,SettingActivty.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmSignOut) {
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        return true ;

    }
    public void showPopUpMenu(View v, MyTasks t){
        //popup menu بناء قائمه
        PopupMenu popup = new PopupMenu(this,v);//الكائن الذي سبب فتح القائمه v
        //ملف القائمه
        popup.inflate(R.menu.popup_menu);
        //اضافه معالج حدث لاختيار عنصر من القائمه
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuitem) {
                if (menuitem.getItemId()==R.id.itmaddtask){
                    Toast.makeText(MainActivity2.this,"Add",Toast.LENGTH_SHORT).show();;
                    Intent i=new Intent(MainActivity2.this,AddTaskActivty.class);
                    startActivity(i);
                }
                if (menuitem.getItemId()==R.id.itmdelete){
                    Toast.makeText(MainActivity2.this,"Delete",Toast.LENGTH_SHORT).show();
                    AppDataBase db= AppDataBase.getDB(MainActivity2.this);
                    MyTasksQuery myTasksQuery=db.getMyTaskQuery();
                    myTasksQuery.deletTask(menuitem.getItemId());
                    initiAlllistView();
                    initSubjectSpnr();
                }
                if (menuitem.getItemId()==R.id.itmedit) {
                    Toast.makeText(MainActivity2.this, "Edit", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        popup.show();

    }
    public void ShowNoYesDialog()
    {
        //تجهيز بناء شباك حوار "ديالوغ" يتلقى بارمتر مؤشر للنشاط (اكتفيتي) الحالي
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Log out");// تحديد العنوان
        builder.setMessage("Are you sure?");//تحديد فحوى الشباك الحوار
        //النص على الزر ومعالج الحدث
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //معالجه الحدث للموافقه
                Toast.makeText(MainActivity2.this,"Signing out",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        AlertDialog dialog= builder.create();// بناء شباك حوار - ديالوغ
        dialog.show();//عرض الشباك
    }


            }




