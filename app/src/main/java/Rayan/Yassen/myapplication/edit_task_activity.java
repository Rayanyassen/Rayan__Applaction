package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class edit_task_activity extends AppCompatActivity {
    private  Button btnUpdate;
    private Button btnCancel;
    private TextView tvImpoertance;
    private SeekBar skbrImportance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
    }
}