package com.facebook.debug.connection;

import android.content.Context;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: inline_action_join_event_click */
public class DataConnectionOverlayPreference extends CheckBoxOrSwitchPreference {
    public DataConnectionOverlayPreference(Context context) {
        super(context);
        setKey(DebugLoggingPrefKeys.f.a());
        setTitle("Data Connection Overlay");
        setSummary("Requires app restart to take effect");
    }
}
