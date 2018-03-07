package com.facebook.ui.browser;

import android.content.Context;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: topic_list_model */
public class BrowserDisabledPreference extends CheckBoxOrSwitchPreference {
    public BrowserDisabledPreference(Context context, int i, int i2, int i3) {
        super(context);
        a(BrowserPrefKey.a);
        setTitle(i);
        setSummaryOff(i2);
        setSummaryOn(i3);
        setDefaultValue(Boolean.valueOf(false));
    }
}
