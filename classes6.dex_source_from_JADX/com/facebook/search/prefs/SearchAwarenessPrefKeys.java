package com.facebook.search.prefs;

import android.net.Uri;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: event_ticket_info */
public class SearchAwarenessPrefKeys {
    public static final PrefKey f15926a;
    public static final PrefKey f15927b;
    public static final PrefKey f15928c = ((PrefKey) f15926a.a("tutorial_nux/"));
    public static final PrefKey f15929d = ((PrefKey) f15926a.a("spotlight/"));
    public static final PrefKey f15930e = ((PrefKey) f15927b.a("next_eligible_fetch_time"));
    public static final PrefKey f15931f = ((PrefKey) f15927b.a("should_force_new_fetch"));
    public static final PrefKey f15932g = ((PrefKey) f15928c.a("debug_mode_enabled"));
    public static final PrefKey f15933h = ((PrefKey) f15929d.a("next_eligible_fetch_time"));
    public static final PrefKey f15934i = ((PrefKey) f15926a.a("opt_out/"));
    private static final PrefKey f15935j = ((PrefKey) f15928c.a("primary_action_clicked/"));
    private static final PrefKey f15936k = ((PrefKey) f15928c.a("impression_count/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("search_awareness/");
        f15926a = prefKey;
        f15927b = (PrefKey) prefKey.a("learning_nux/");
    }

    public static PrefKey m23545a(String str) {
        return (PrefKey) f15936k.a(Uri.encode(str));
    }

    public static PrefKey m23546b(String str) {
        return (PrefKey) f15935j.a(Uri.encode(str));
    }

    public static PrefKey m23547c(String str) {
        return (PrefKey) f15934i.a(str);
    }
}
