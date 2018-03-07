package com.facebook.video.commercialbreak.prefs;

import android.content.Context;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: location_settings_switch_history */
public class CommercialBreakPreferences extends PreferenceCategory {
    public CommercialBreakPreferences(Context context) {
        this(context, null);
    }

    private CommercialBreakPreferences(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommercialBreakPreferences(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Commercial Break");
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(getContext());
        checkBoxOrSwitchPreference.a(CommercialBreakPreferencesKeys.f9778a);
        checkBoxOrSwitchPreference.setTitle("Enable Debug Toasts");
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        addPreference(checkBoxOrSwitchPreference);
    }
}
