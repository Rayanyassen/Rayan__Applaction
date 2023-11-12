package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class AddTaskActivty extends AppCompatActivity {
    private TextInputLayout etE_mail;
    private TextInputLayout etpassword;
    private TextInputLayout etre_password ;
    private TextInputLayout etname ;
    private TextInputLayout etphone;
    private Button btnSave;
    private Button BTNCancel;
    private TextView tvImpoertance;
    private SeekBar skbrImportance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_activty);
        etE_mail=findViewById(R.id.etE_mail);
        etpassword=findViewById(R.id.etpassword);
        etre_password=findViewById(R.id.etre_password);
        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        btnSave=findViewById(R.id.btnSave);
        BTNCancel=findViewById(R.id.BTNCancel);
        tvImpoertance=findViewById(R.id.tvImpoertance);
        skbrImportance=findViewById(R.id.skbrImportance);



    }
}