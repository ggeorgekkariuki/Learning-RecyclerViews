package com.example.learningrecyclerviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        Overriding this method allows us to specify the options menu for MainActivity and
        inflate our menu resource R.menu.menu
        You can also add menu items using add() and retrieve items with findItem()
         */
//        Inflate Menu Resource
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        Adding a menu item
        MenuItem searchMenuItem = menu.findItem(R.id.search_view);

//        A SearchView widget  provides a user interface for the user to enter a search query and submit a request to a search provider.
//        An action view is an action that provides rich functionality within the app bar. For example, a search action view allows the user to type their search text in the app bar, without having to change activities or fragments.
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
//        Sets the specified maximum width in pixels, if set. Returns zero if no maximum width was specified.
        searchView.setMaxWidth(Integer.MAX_VALUE);

//        Sets a listener for user actions within the SearchView.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                The adapter can filter characters and display them
                mUserAdapter.getFilter().filter(s);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        When the user selects an item from the options menu (including action items in the app bar), the system calls this method.
         You can identify the item by calling getItemId() and match this ID against known menu items to perform the appropriate action
         */
        switch (item.getItemId()){
            case R.id.search_view:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
