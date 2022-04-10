package com.example.contactrecyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactrecyclerview.databinding.ContactItemBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<ContactType> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ContactItemBinding contactItemBinding;
        private Context context;
        public ViewHolder(ContactItemBinding contactItemBinding) {
            super(contactItemBinding.getRoot());
            // Define click listener for the ViewHolder's View
            this.context = contactItemBinding.getRoot().getContext();
            this.contactItemBinding = contactItemBinding;

        }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ContactAdapter(ArrayList<ContactType> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        ContactItemBinding view = ContactItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        ContactType data = localDataSet.get(position);
        ConstraintLayout container = viewHolder.contactItemBinding.container;
        TextView cardTitle = viewHolder.contactItemBinding.cardTitle;
        TextView email = viewHolder.contactItemBinding.email;
        Button deleteButton = viewHolder.contactItemBinding.deleteButton;
        cardTitle.setText(data.name);
        email.setText(data.email);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.context, DetailContact.class);
                intent.putExtra("name", data.name);
                intent.putExtra("email", data.email);
                viewHolder.context.startActivity(intent);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localDataSet.remove(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
