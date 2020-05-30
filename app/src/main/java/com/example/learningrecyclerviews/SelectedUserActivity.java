package com.example.learningrecyclerviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class SelectedUserActivity extends AppCompatActivity {
//    Global variables
    TextView tvSelectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

//        Find a reference to the TextView in the layout
        tvSelectedUser = findViewById(R.id.tvSelectedUser);

//        Receive the intent from MainActivity
        Intent intent = getIntent();
//        Find any Extras passed from the MainActivity
        if(intent.getExtras() != null){
            UserModel userModel = (UserModel) intent.getSerializableExtra("EXTRA_DATA");
//            Pass the data to the View
            tvSelectedUser.setText(userModel.getUserName());
        }
    }
}
