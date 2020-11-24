package com.example.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TestToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);

        // this gets the toolbar from the layout
        Toolbar tBar = (Toolbar) findViewById(R.id.toolbar);

        //This loads the toolbar, which calls onCreateOptionMev
        setSupportActionBar(tBar);

        //For NavigationDrawer:
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, tBar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (item -> {

            switch (item.getItemId())
            {
                case R.id.chatPage:
                    Intent goToChat = new Intent(this, ChatRoomActivity.class);
                    startActivity(goToChat);
                    break;
                case R.id.weatherPageIcon:
                    Intent goToWeather = new Intent(this, WeatherForecast.class);
                    startActivity(goToWeather);
                    break;
                case R.id.goBackPgeIcon:
                    setResult(500);
                    finish();
                    break;

            }

            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitems, menu);
    //    MenuInflater inflater2 = getMenuInflater();
       // inflater.inflate(R.menu.nagvigationmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = null;
        //Look at your menu XML file. Put a case for every id in that file:
        switch (item.getItemId()) {
            //what to do when the menu item is selected:
            case R.id.homeIcon:
                message = "You clicked on item 1";
                break;
            case R.id.musicIcon:
                message = "You clicked on item 2";
                break;
            case R.id.searchIcon:
                message = "You clicked on item 3";
                break;

            case R.id.weatherIcon:
                message = "you clicked on the overflow menu";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        return true;
    }



    // Needed for the OnNavigationItemSelected interface:
/*
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.chatPage:
                Intent goToChat = new Intent(this, ChatRoomActivity.class);
                startActivity(goToChat);
                break;
            case R.id.weatherPageIcon:
                Intent goToWeather = new Intent(this, WeatherForecast.class);
                startActivity(goToWeather);
                break;
            case R.id.goBackPgeIcon:
                finish();
                break;

        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
