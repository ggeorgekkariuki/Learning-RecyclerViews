package com.example.learningrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {
//    Global variables
    TextView tvSelectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

//        Find a reference to the TextView in the layout
        tvSelectedUser = findViewById(R.id.tvSelectedUser);
    }
}
