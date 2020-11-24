package com.example.androidlabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton mImageButton;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(ACTIVITY_NAME,"In function : " + "onCreate");

        setContentView(R.layout.activity_profile);

        Intent fromMain = getIntent();
        String typed =fromMain.getStringExtra("emailTyped");

        EditText emailAddress = findViewById(R.id.emailEdit);
                emailAddress.setText(typed);

        mImageButton =(ImageButton)findViewById(R.id.imageButton);
        mImageButton.setOnClickListener(bt -> dispatchTakePictureIntent());


        Button chatButton = findViewById(R.id.chatButton);
        Intent goToChat = new Intent(this, ChatRoomActivity.class);
        chatButton.setOnClickListener(click -> startActivity(goToChat));


        Button weatherButton = findViewById(R.id.weatherButton);
        Intent goToWeather = new Intent(this, WeatherForecast.class);
        weatherButton.setOnClickListener(click -> startActivity(goToWeather));

        Button toolbarButton =findViewById(R.id.toolbarButton);
        Intent goToTestToolbar = new Intent(this, TestToolbar.class);
        toolbarButton.setOnClickListener(click -> startActivityForResult(goToTestToolbar, 499));;

    }


    private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(ACTIVITY_NAME,"In function : " + "onActivityResult");

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }

        if (requestCode == 499 && resultCode == 500){
            finish();
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ACTIVITY_NAME,"In function : " + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME,"In function : " + "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(ACTIVITY_NAME,"In function : " + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME,"In function : " + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME,"In function : " + "onDestroy");
    }


}