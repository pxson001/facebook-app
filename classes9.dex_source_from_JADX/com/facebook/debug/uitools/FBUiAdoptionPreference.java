package com.facebook.debug.uitools;

import android.content.Context;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: picker_type */
public class FBUiAdoptionPreference extends CheckBoxOrSwitchPreference {
    public FBUiAdoptionPreference(Context context) {
        super(context);
        a(UIToolsPrefs.f6594b);
        setDefaultValue(Boolean.valueOf(false));
        setTitle("UI Infra Adoption");
        setSummary("Highlight parts of the app that uses UI Infra components");
    }
}
