package com.trile.scorekeeper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SwitchCompat;

public class NightModeFragment extends Fragment {

    SwitchCompat switchNightMode;

    public NightModeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);

        switchNightMode = view.findViewById(R.id.switchNightMode);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchNightMode.setChecked(true);
        }
        return view;
    }

    private void setupSwitchNightModeListener() {
        switchNightMode.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                // Set to dark mode
//                ((ScoreKeeperApplication) getApplication()).setIsNightModeEnabled(true);
//                Intent intent = getIntent();
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                finish();
//                startActivityForResult(intent, 0);
//                overridePendingTransition(0,0);
            } else {
//                ((ScoreKeeperApplication) getApplication()).setIsNightModeEnabled(false);
//                Intent intent = getIntent();
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                finish();
//                startActivityForResult(intent, 0);
//                overridePendingTransition(0,0);
            }
        });
    }
}