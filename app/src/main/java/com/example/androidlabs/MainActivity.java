package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        Button b1 = findViewById(R.id.button1);
        b1.setOnClickListener((v) ->{
            Toast.makeText(MainActivity.this,  getResources().getString(R.string.toast_message),Toast.LENGTH_LONG).show();
          getResources().getString(R.string.toast_message);
                   //getResources().getString(R.string.toast_message);


        });

    Switch s1 = findViewById(R.id.switch1);
    s1.setOnCheckedChangeListener((whatClicked,newState)-> {
        if (newState)
            Snackbar.make(s1, getResources().getString(R.string.on_message), Snackbar.LENGTH_SHORT).setAction(getResources()
                    .getString(R.string.undo_message), (v) -> s1.setChecked(false)).show();
        else
            Snackbar.make(s1,  getResources().getString(R.string.off_message), Snackbar.LENGTH_SHORT).show();
        });
        //setAction(getResources().getString(R.string.undo_message)
    }

}