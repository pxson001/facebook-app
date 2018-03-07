package com.facebook.http.strictsocket;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.http.strictsocket.StrictSocketManager.Mode;
import com.facebook.widget.prefs.OrcaListPreferenceWithSummaryValue;

/* compiled from: view_profile_video */
public class StrictSocketPreference extends OrcaListPreferenceWithSummaryValue implements OnPreferenceChangeListener {
    private final StrictSocketManager f408b;

    public StrictSocketPreference(Context context, StrictSocketManager strictSocketManager) {
        super(context);
        this.f408b = strictSocketManager;
        setTitle(2131241487);
        setDefaultValue("off");
        setEntries(2131755092);
        setEntryValues(2131755093);
        setOnPreferenceChangeListener(this);
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        Mode valueOf = Mode.valueOf((String) obj);
        if (valueOf == null) {
            return false;
        }
        this.f408b.m522a(valueOf);
        return true;
    }
}
