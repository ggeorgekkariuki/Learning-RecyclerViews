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
    public void onBindViewHolder(@NonNull UserAdapter.UserModelViewHolder userModelViewHolder, int position) {
         /*
        The layout manager then binds the view holder to its data.
        It does this by calling the adapter's onBindViewHolder() method, and passing
        the view holder's position in the RecyclerView.
        The onBindViewHolder() method needs to fetch the appropriate data, and use it to fill in
        the view holder's layout.
         */
//         Find the data in the UserModel at the current position
         UserModel userModel = mUserModelList.get(position);
//         Use this userModel object to fill in variables that will later be used to fill in the individual views nested in the ViewHolder
        String username = userModel.getUserName();
        String prefix = userModel.getUserName().substring(0,1);
//        Use the variables to fill in the ViewHolder views eg tvUsername and tvPrefix
        userModelViewHolder.tvUsername.setText(username);
        userModelViewHolder.tvPrefix.setText(prefix);
    }

    @Override
    public int getItemCount() {
//        Find the size of the whole list - this size will be used to find the position of an individual data item that needs to be displayed
        return mUserModelList.size();
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

