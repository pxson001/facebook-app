package com.facebook.debug.uitools;

import android.content.Context;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: picker_screen_data */
public class NodeScannerPreference extends CheckBoxOrSwitchPreference {
    public NodeScannerPreference(Context context) {
        super(context);
        a(UIToolsPrefs.f6596d);
        setDefaultValue(Boolean.valueOf(false));
        setTitle("Node Scanner");
        setSummary("Highlight parts of the app that uses Views that does not support interaction");
    }
}
