package com.trile.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (((ScoreKeeperApplication) getApplication()).isNightModeEnabled() == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_main);

        // set default view
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,ContentFragment.class,null );
        fragmentTransaction.commit();

        // Phone is in potrait mode
        if(findViewById(R.id.layout_default) !=null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout_main,ContentFragment.class,null );
            fragmentTransaction.commit();
        }else{
            // Phone is in landspace mode // for testing we hide the night mode since its not placed well
            fragmentTransaction = fragmentManager.beginTransaction();
            //fragmentTransaction.hide(NightModeFragment.class)
            fragmentTransaction.commit();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,ContentFragment.class,null );
        fragmentTransaction.commit();
    }


}