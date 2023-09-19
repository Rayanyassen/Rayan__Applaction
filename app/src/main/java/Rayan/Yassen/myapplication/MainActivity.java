package Rayan.Yassen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("yassen", "onCreate: ");
        Toast.makeText(this, "onCreate:",Toast.LENGTH_SHORT).show();
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

