package com.example.learningrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
//    Creating fields
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Obtaining a reference to the RecyclerView and the Toolbar
        mRecyclerView = findViewById(R.id.recyclerView);
        mToolbar = findViewById(R.id.toolbar);

//        An application may choose to designate a Toolbar as the action bar for an Activity using the setActionBar() method.
        this.setSupportActionBar(mToolbar);
//        Prohibit the app from setting the Application-wide/Manifest title as Title
        this.getSupportActionBar().setTitle("");

//        The LayoutManager is responsible for measuring and positioning item views within a
//        RecyclerView as well as determining the policy for when to recycle item views that are
//        no longer visible to the user.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        This is used as a divider between items of a LinearLayoutManager
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
