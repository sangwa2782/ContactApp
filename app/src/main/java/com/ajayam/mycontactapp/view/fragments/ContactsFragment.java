package com.ajayam.mycontactapp.view.fragments;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajayam.mycontactapp.R;

import com.ajayam.mycontactapp.adapters.ContactsListAdapter;
import com.ajayam.mycontactapp.databinding.FragmentContactsBinding;
import com.ajayam.mycontactapp.models.ContactList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {


    FragmentContactsBinding binding;
    ContactsListAdapter adapter;

    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> phoneNumber = new ArrayList<>();


    public ContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = binding.inflate(inflater, container, false);


        try {
            setAdapter();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return binding.getRoot();
    }

    private void setAdapter() throws JSONException, IOException {
        List<ContactList> list = getContactList();
        binding.rvContactList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ContactsListAdapter(getContext(), list);
        binding.rvContactList.setAdapter(adapter);
    }


    private String readContactsFromResources() throws IOException {
        StringBuilder statesJson = new StringBuilder();
        Resources resources = getResources();
        InputStream rawStates = resources.openRawResource(R.raw.contacts);
        BufferedReader reader = new BufferedReader(new InputStreamReader(rawStates));
        String line;
        while ((line = reader.readLine()) != null) {
            statesJson.append(line);
        }

        return statesJson.toString();
    }



    private List<ContactList> getContactList() throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray(readContactsFromResources());
        JSONObject contact;
        List<ContactList> tmpContactList = new ArrayList<>(jsonArray.length());
        for(int i = 0; i < jsonArray.length(); i++) {
            contact = jsonArray.getJSONObject(i);
             String name = contact.getString("name");
             String countryCode = contact.getString("country_code");
             Integer contactNumber = Integer.valueOf(contact.getString("number"));
            tmpContactList.add(new ContactList(name,contactNumber,countryCode));
        }
        return tmpContactList;
    }
}