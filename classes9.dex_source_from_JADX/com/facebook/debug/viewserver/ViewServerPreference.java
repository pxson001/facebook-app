package com.facebook.debug.viewserver;

import android.content.Context;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: pic_big */
public class ViewServerPreference extends CheckBoxOrSwitchPreference {
    public ViewServerPreference(Context context) {
        super(context);
        a(ViewServerModule.a);
        setDefaultValue(Boolean.valueOf(false));
        setTitle(2131240002);
        setSummary(2131240003);
    }
}
