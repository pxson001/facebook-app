package com.facebook.bugreporter;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: android.media.metadata.TITLE */
public class BugReporterPrefKeys {
    public static final PrefKey f10628a;
    public static final PrefKey f10629b;
    public static final PrefKey f10630c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("bug_reporting/");
        f10628a = prefKey;
        prefKey = (PrefKey) prefKey.a("rageshake/");
        f10629b = prefKey;
        f10630c = (PrefKey) prefKey.a("enable");
    }
}
