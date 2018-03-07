package com.facebook.debug.feed;

import android.content.Context;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: open_composer */
public class HomeStoriesOverlayPreference extends CheckBoxOrSwitchPreference {
    public HomeStoriesOverlayPreference(Context context) {
        super(context);
        setKey(DebugLoggingPrefKeys.h.a());
        setTitle("Home Stories Overlay");
        setSummary("Requires app restart to take effect");
    }
}
