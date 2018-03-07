package com.facebook.debug.uitools;

import android.content.Context;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: pic_square_with_logo */
public class UIMonitorPreference extends CheckBoxOrSwitchPreference {
    public UIMonitorPreference(Context context) {
        super(context);
        a(UIToolsPrefs.f6593a);
        setDefaultValue(Boolean.valueOf(false));
        setTitle("Enable UIMonitor");
        setSummary("Shows what Views request layout and get repainted. Requires restart.");
    }
}
