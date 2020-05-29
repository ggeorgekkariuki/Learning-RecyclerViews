package com.example.learningrecyclerviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserModelViewHolder> {
    /*
    To feed all your data to the list that can be viewed, you must extend the RecyclerView.Adapter class.
    This object creates views for items, and replaces the content of some of the views with new data items when the original item is no longer visible.
     */

//    Variables for the constructor
    private List<UserModel> mUserModelList;
    private Context mContext;

    public UserAdapter(List<UserModel> userModelList) {
        this.mUserModelList = userModelList;
    }

    @NonNull
    @Override
    public UserAdapter.UserModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*
        This method constructs a RecyclerView.ViewHolder and sets the view it uses to display its contents.
        The type of the ViewHolder must match the type declared in the Adapter class signature.
         */
//        Set the context
        mContext = viewGroup.getContext();
//        Return a ViewHolder which inflates a layout 'row_users'
        return new UserModelViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_users, null));
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
//        Variables to be used in the creating the view
        TextView tvPrefix;
        TextView tvUsername;
        ImageView imIcon;

        public UserModelViewHolder(@NonNull View itemView) {
            super(itemView);
//            References for the individual item view to be used for a single data entry
            tvPrefix = itemView.findViewById(R.id.tvPrefix);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            imIcon = itemView.findViewById(R.id.imageView);
        }
    }
}

