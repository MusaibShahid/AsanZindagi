package com.duakhan.AsanZindagi.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.duakhan.AsanZindagi.Doctor_Fragment;
import com.duakhan.AsanZindagi.Lawyer_Fragment;
import com.duakhan.AsanZindagi.Tutor;

public class pagerAdapter extends FragmentPagerAdapter {
    private  int tabsNumber;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment= new Doctor_Fragment();
                break;
            case  1:
                fragment= new Lawyer_Fragment();
                break;
            case 2:
                fragment= new Tutor();
                break;

        }
return fragment;
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
