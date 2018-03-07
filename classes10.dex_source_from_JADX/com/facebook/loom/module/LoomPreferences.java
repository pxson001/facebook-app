package com.facebook.loom.module;

import android.content.Context;
import android.os.Build.VERSION;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.loom.core.LoomConstants;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: threadsUpdatedReceiver */
public class LoomPreferences extends PreferenceCategory {
    public LoomPreferences(Context context) {
        super(context);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Loom");
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(getContext());
        checkBoxOrSwitchPreference.a(LoomConstants.a);
        checkBoxOrSwitchPreference.setTitle("Enable manual tracing");
        if (VERSION.SDK_INT >= 14) {
            checkBoxOrSwitchPreference.setSummaryOff("Tap to enable manual controls (see notification)");
            checkBoxOrSwitchPreference.setSummaryOn("Tap to disable manual controls");
        }
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        addPreference(checkBoxOrSwitchPreference);
    }
}
