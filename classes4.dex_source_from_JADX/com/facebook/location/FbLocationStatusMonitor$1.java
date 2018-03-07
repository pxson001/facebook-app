package com.facebook.location;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: is_on_wifi */
class FbLocationStatusMonitor$1 implements OnSharedPreferenceChangeListener {
    final /* synthetic */ FbLocationStatusMonitor f9938a;

    FbLocationStatusMonitor$1(FbLocationStatusMonitor fbLocationStatusMonitor) {
        this.f9938a = fbLocationStatusMonitor;
    }

    public final void m10324a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        if (prefKey.equals(FbLocationStatusMonitor.d)) {
            FbLocationStatusMonitor.d(this.f9938a);
        }
    }
}
