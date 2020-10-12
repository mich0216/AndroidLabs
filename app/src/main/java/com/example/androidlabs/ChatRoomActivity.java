package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatRoomActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>( );
    private MessageAdaptor myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

       /* Button sendButton = findViewById(R.id.sendButton);
          sendButton.setOnClickListener(click -> {
           list.add("hi");
          myAdapter.notifyDataSetChanged();
        });

      EditText chat = findViewById(R.id.chatEditText);*/



        ListView myList = findViewById(R.id.listView);
        myList.setAdapter(myAdapter = new MessageAdaptor());


     }

    private class MessageAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =getLayoutInflater();
            View newView = inflater.inflate(R.layout.sendlayout,parent, false);


            return newView;
        }

        @Override
        public long getItemId(int position) {
            return (long) position;
        }
    }




}