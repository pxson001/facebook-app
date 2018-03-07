package com.facebook.debug.feed;

import android.content.Context;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: open_draft */
public class FreshFeedOverlayPreference extends CheckBoxOrSwitchPreference {
    public FreshFeedOverlayPreference(Context context) {
        super(context);
        setKey(DebugLoggingPrefKeys.i.a());
        setTitle("Fresh Feed Overlay");
        setSummary("Requires app restart to take effect");
    }
}
