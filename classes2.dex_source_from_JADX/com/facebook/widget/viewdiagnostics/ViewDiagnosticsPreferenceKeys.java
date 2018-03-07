package com.facebook.widget.viewdiagnostics;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: min_unshown_stories_in_feed_adapter_by_cc */
public class ViewDiagnosticsPreferenceKeys {
    public static final PrefKey f13485a;
    public static final PrefKey f13486b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("view_diagnostics/");
        f13485a = prefKey;
        f13486b = (PrefKey) prefKey.m2011a("display_enabled");
    }
}
