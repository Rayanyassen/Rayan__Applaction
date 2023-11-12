package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    private FloatingActionButton fabAdd;
    private SearchView srchV;
    private Spinner spnrSubject2;
    private ListView lstvTasks;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       fabAdd=findViewById(R.id.fabAdd);
       srchV=findViewById(R.id.srchV);
       spnrSubject2=findViewById(R.id.spnrSubject2);
       lstvTasks=findViewById(R.id.lstvTasks);
       
    }
}