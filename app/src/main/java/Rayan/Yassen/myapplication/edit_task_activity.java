package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class edit_task_activity extends AppCompatActivity {
    private Button btnUpdate;
    private Button btnCancel;
    private TextView tvImpoertance;
    private SeekBar skbrImportance;
    private TextInputEditText etShortTitle;
    private TextInputEditText etText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnCancel=findViewById(R.id.BTNCancel);
        tvImpoertance=findViewById(R.id.tvImpoertance);
        skbrImportance=findViewById(R.id.skbrImportance);
        etShortTitle=findViewById(R.id.etShortTitle);
        etText=findViewById(R.id.etText);

    }
}