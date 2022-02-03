package com.sp.shelterleh;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import java.util.prefs.Preferences;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.settings,rootKey);

        PreferenceScreen screen = getPreferenceScreen();
        final ListPreference listPreference = (ListPreference) findPreference("theme");
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                listPreference.setValue(newValue.toString());
                String theme = String.valueOf(listPreference.getEntry());
                Log.d("debug", theme);
                if (theme.equals("Light")) {
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
                }
                if (theme.equals("Dark")) {
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
                }
                if (theme.equals("System default")) {
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM);
                }
                return true;
            }
        });
    }
}

