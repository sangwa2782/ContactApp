package com.ajayam.mycontactapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayam.mycontactapp.R;
import com.ajayam.mycontactapp.databinding.ContactListViewBinding;
import com.ajayam.mycontactapp.models.ContactList;
import com.ajayam.mycontactapp.view.ContactInfoActivity;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.MyViewHolder> {
    Context context;
    View view;
    List<ContactList> list;

    public ContactsListAdapter(Context context, List<ContactList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ContactsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.contact_list_view, parent, false);
        return new ContactsListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvContactName.setText(String.valueOf(list.get(position).getName()));
        holder.binding.tvContactNumber.setText(list.get(position).getCountryCode()+" "+list.get(position).getNumber());
        setOnClick(holder,position);
    }

    private void setOnClick(MyViewHolder holder, int position) {
        holder.binding.llParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ContactInfoActivity.class)
                        .putExtra("NAME", list.get(position).getName())
                        .putExtra("NUMBER", String.valueOf(list.get(position).getNumber()))
                        .putExtra("CODE", list.get(position).getCountryCode()
                        ));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ContactListViewBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ContactListViewBinding.bind(itemView);
            binding.tvContactName.setText("Hello");
        }
    }
}
