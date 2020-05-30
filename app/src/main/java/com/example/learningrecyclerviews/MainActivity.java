package com.example.learningrecyclerviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.SelectedUser{
//    Creating fields
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    UserAdapter mUserAdapter;
//    A List of Users from the UserModel
    List<UserModel> userModelList = new ArrayList<>();
//    The data of users
    String[] names = {"Richard Brandson", "Dawson Creek", "Mary Magdalene", "Hermoine Granger", "Weasley Knight", "Kingsley White"};
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
//        LinearLayoutManager arranges the items in a one-dimensional list. Using a RecyclerView with LinearLayoutManager provides functionality like the older ListView layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        This is used as a divider between items of a LinearLayoutManager
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

//        Pass the data to the UserModel List
        for(String name: names){
//            Pass the data into the constructor to create instances of the UserModel
            UserModel userModel = new UserModel(name);
//            Add the userModel object to the List
            userModelList.add(userModel);
        }

//        Adapter obtains a reference to the data being passed
        mUserAdapter = new UserAdapter(userModelList, this);
//        Attaching the UserAdapter to the RecyclerView
        mRecyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public void selectedUser(UserModel usermodel) {
//        Create a new Activity once user is selected.
//        Pass an intent from MainActivity to the SelectedUserActivity and pass a UserModel object
        startActivity(new Intent(MainActivity.this, SelectedUserActivity.class).putExtra("EXTRA_DATA", usermodel));
    }
}
