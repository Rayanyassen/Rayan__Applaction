package Rayan.Yassen.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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


        }
        if (item.getItemId() == R.id.itmSignOut) {
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();

        }
        return true ;

    }
}