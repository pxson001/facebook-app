package com.facebook.aldrin.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;

/* compiled from: line-break */
public class LaunchAldrinInternSettingsPreference extends Preference {
    public LaunchAldrinInternSettingsPreference(Context context) {
        super(context);
        setTitle("Aldrin Internal Settings");
        setIntent(new Intent(getContext(), AldrinInternSettingsActivity.class));
    }
}
