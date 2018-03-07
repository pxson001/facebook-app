package com.facebook.work.config;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: total_swappable */
public class WorkPrefKeys {
    public static final PrefKey f846a;
    @Deprecated
    public static final PrefKey f847b;
    @Deprecated
    public static final PrefKey f848c = ((PrefKey) f846a.a("community_logo_url"));
    public static final PrefKey f849d;
    public static final PrefKey f850e = ((PrefKey) f858m.a("name"));
    public static final PrefKey f851f = ((PrefKey) f858m.a("subdomain"));
    public static final PrefKey f852g = ((PrefKey) f858m.a("logo_url"));
    public static final PrefKey f853h;
    public static final PrefKey f854i = ((PrefKey) f859n.a("last_reauth_ts"));
    public static final PrefKey f855j = ((PrefKey) f859n.a("reauth_activity_verifier"));
    public static final PrefKey f856k = ((PrefKey) f846a.a("saved_accounts/"));
    public static final PrefKey f857l = ((PrefKey) f846a.a("pending_auth_email"));
    private static final PrefKey f858m;
    private static final PrefKey f859n;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("work/");
        f846a = prefKey;
        f847b = (PrefKey) prefKey.a("community_name");
        prefKey = (PrefKey) SharedPrefKeys.d.a("work_community/");
        f858m = prefKey;
        f849d = (PrefKey) prefKey.a("id");
        prefKey = (PrefKey) SharedPrefKeys.a.a("work_reauth/");
        f859n = prefKey;
        f853h = (PrefKey) prefKey.a("code_verifier");
    }
}
