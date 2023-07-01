package com.ajayam.mycontactapp.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ajayam.mycontactapp.view.fragments.ContactsFragment;
import com.ajayam.mycontactapp.view.fragments.MessagesFragment;

public class ViewPagerMassangerApp extends FragmentPagerAdapter {
    public ViewPagerMassangerApp(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ContactsFragment();
        } else {
            return new MessagesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
        // No. of tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Contacts";
        } else {
            return "Messages";
        }

    }
}
