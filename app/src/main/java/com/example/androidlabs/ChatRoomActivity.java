package com.example.androidlabs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

public class ChatRoomActivity extends AppCompatActivity {

    private ArrayList<Message> list = new ArrayList<>( );
    private MessageAdaptor myAdapter;
    private EditText chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat_room);

        ListView myList = findViewById(R.id.listView);
        myList.setAdapter(myAdapter = new MessageAdaptor());
        myList.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(getResources().getString(R.string.wantdelete))

            .setMessage(getResources().getString(R.string.selectedrow)+position+ "\n" +
                    (getResources().getString(R.string.thedatabaseid)+id))

            .setPositiveButton((getResources().getString(R.string.yes)), (click, arg)-> {
                list.remove(position);
                myAdapter.notifyDataSetChanged();
            })
             .setNegativeButton((getResources().getString(R.string.no)),(click, arg)->{})

            .create().show();

            return true;
        });


        chat = findViewById(R.id.chatEditText);

       Button sendButton = findViewById(R.id.sendButton);
          sendButton.setOnClickListener(click -> {
              String sendText = chat.getText().toString();
              Message sendMessage = new Message(sendText, false);
              list.add(sendMessage);
              chat.setText("");

              myAdapter.notifyDataSetChanged();


        });

        Button receiveButton = findViewById(R.id.receiveButton);
        receiveButton.setOnClickListener(click -> {
            String receiveText = chat.getText().toString();
            Message receiveMessage = new Message(receiveText, true);
            list.add(receiveMessage);
            chat.setText("");
            myAdapter.notifyDataSetChanged();
        });


      EditText chat = findViewById(R.id.chatEditText);




     }

    private class MessageAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Message getItem(int position) {
            return list.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =getLayoutInflater();
            View newView = convertView;

            if (list.get(position).getReceivedMessage()) {
                newView =inflater.inflate(R.layout.receivelayout, parent, false);
                TextView tv = newView.findViewById(R.id.receiveMessage);
                tv.setText(getItem(position).getMessage());

            }else{
                newView =inflater.inflate(R.layout.sendlayout, parent, false);
                TextView tv = newView.findViewById(R.id.sendMessage);
                tv.setText(getItem(position).getMessage());

            }

            return newView;
        }

        @Override
        public long getItemId(int position) {
            return (long) position;
        }
    }




}