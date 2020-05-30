package com.example.learningrecyclerviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserModelViewHolder> implements Filterable {
    /*
    To feed all your data to the list that can be viewed, you must extend the RecyclerView.Adapter class.
    This object creates views for items, and replaces the content of some of the views with new data items when the original item is no longer visible.
     */
//    Variable for the filter
    private List<UserModel> mGetUserModelListFiltered;

//    Variables for the constructor
    private List<UserModel> mUserModelList;
    private Context mContext;
    private SelectedUser mSelectedUser;

    public UserAdapter(List<UserModel> userModelList, SelectedUser selectedUser) {
        this.mUserModelList = userModelList;
        this.mSelectedUser = selectedUser;
        this.mGetUserModelListFiltered = userModelList;
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

    @Override
    public Filter getFilter() {
        /*
        A filterable class can have its data constrained by a filter.
        A filter constrains data with a filtering pattern.
        Filters are usually created by Filterable classes.
        Filtering operations performed by calling filter(java.lang.CharSequence) or filter(java.lang.CharSequence, android.widget.Filter.FilterListener) are performed asynchronously.
        When these methods are called, a filtering request is posted in a request queue and processed later.
         */
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
//                Invoked in a worker thread to filter the data according to the constraint.
                FilterResults filterResults = new FilterResults();

                if (charSequence == null | charSequence.length() == 0){
                    filterResults.count = mGetUserModelListFiltered.size();
                    filterResults.values = mGetUserModelListFiltered;
                } else {
//                    Find the character being searched for
                    String searchCharacter = charSequence.toString().toLowerCase();
//                    Create a new Array List that will be based off the results of the search
                    List<UserModel> resultData = new ArrayList<>();
//                    Loop through the UserModel
                    for (UserModel userModel: mGetUserModelListFiltered){
//                        If a user has the same characters
                        if(userModel.getUserName().toLowerCase().contains(searchCharacter)){
//                            Add them to the result List
                            resultData.add(userModel);
                        }
                    }
//                    Change the filter results
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                Invoked in the UI thread to publish the filtering results in the user interface.
                mUserModelList = (List<UserModel>) filterResults.values;
//                Notify the Adapter that the data has changed
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public interface SelectedUser{
        /*
        An interface is a collection of abstract methods. An interface contains behaviors that a class implements.
         */
        void selectedUser(UserModel usermodel);
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

//            Once the ViewHolder is tapped
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Find the position of the Adapter on the item that has been clicked on
                    mSelectedUser.selectedUser(mUserModelList.get(getAdapterPosition()));
                }
            });
        }
    }
}

