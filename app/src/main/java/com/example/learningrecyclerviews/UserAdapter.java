package com.example.learningrecyclerviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserModelViewHolder> {
    /*
    To feed all your data to the list that can be viewed, you must extend the RecyclerView.Adapter class.
    This object creates views for items, and replaces the content of some of the views with new data items when the original item is no longer visible.
     */

//    Variables for the constructor
    private List<UserModel> mUserModels;
    private Context mContext;

    public UserAdapter(List<UserModel> userModels) {
        this.mUserModels = userModels;
    }

    @NonNull
    @Override
    public UserAdapter.UserModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserModelViewHolder userModelViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserModelViewHolder extends RecyclerView.ViewHolder{
        /*
        A ViewHolder describes an item view and metadata about its place within the RecyclerView.
        ViewHolder is a static inner class in our Adapter which holds references to the relevant view's.
        One ViewHolder object is created for every time the onCreateViewHolder is called.
         */
        public UserModelViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

