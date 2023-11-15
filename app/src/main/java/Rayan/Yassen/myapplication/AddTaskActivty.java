package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivty extends AppCompatActivity {
    private TextInputEditText etshort_title;
    private TextInputEditText et_Text;
    private Button btnSave;
    private Button BTNCancel;
    private TextView tvImpoertance;
    private SeekBar skbrImportance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_activty);
        etshort_title=findViewById(R.id.etshort_title);
        et_Text=findViewById(R.id.et_Text);
        btnSave=findViewById(R.id.btnSave);
        BTNCancel=findViewById(R.id.BTNCancel);
        tvImpoertance=findViewById(R.id.tvImpoertance);
        skbrImportance=findViewById(R.id.skbrImportance);



    }


}