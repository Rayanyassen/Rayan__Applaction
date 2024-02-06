package Rayan.Yassen.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class splashscreen extends AppCompatActivity {
    //spnr1 تعريف صفه الكائن المرئي
    private Spinner spnrSubject;
    private TextView ET_Text;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreenactivty);
        ET_Text= findViewById(R.id.ET_Text);


        Handler h=new Handler();
        Runnable r=new Runnable() {

            public void run()
            {
                //to open new activity from current to next
                Intent i= new Intent(splashscreen.this, SignIn.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r,3000);


}




    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}

