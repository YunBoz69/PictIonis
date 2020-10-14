package com.example.pictonis;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.FirebaseError;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Vector;

public class ListUser extends AppCompatActivity {

    RelativeLayout activity_listuser;

    FirebaseListAdapter adapter;
    private FirebaseAuth mAuth;
    ListView listOfUser;
    Vector<String> array;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference usersdRef = rootRef.child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listuser);

        displayChatMessage();
    }
    private void displayChatMessage() {

        String[] listitem = {FirebaseAuth.getInstance().getCurrentUser().getEmail()};
        ListView listOfUser = (ListView)findViewById(R.id.list_of_user);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listitem);
        listOfUser.setAdapter(adapter);
    }
        /*
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userID = user.getUid();
        activity_listuser = (RelativeLayout) findViewById(R.id.activity_listuser);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();



        rootRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    listOfUser = (ListView) findViewById(R.id.list_of_user);
                    String tempName = data.child("name").getValue(String.class);
                    String[] listitem = {"dada"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listitem);
                    listOfUser.setAdapter(adapter);
                    //with tempName you can access their usernames and you will only get the usernames with session 2011, so you can directly populate your listView from here and use it

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
/*
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String name = ds.child("name").getValue(String.class);

                    array.add(name);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter(ListUser.this, android.R.layout.simple_list_item_1, array);

                listOfUser.setAdapter(adapter);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
        usersdRef.addListenerForSingleValueEvent(eventListener);*/
    }




