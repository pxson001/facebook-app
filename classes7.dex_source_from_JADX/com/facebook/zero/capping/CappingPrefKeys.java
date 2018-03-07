package com.facebook.zero.capping;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.zero.common.constants.ZeroPrefKeys;

/* compiled from: ्ई */
public class CappingPrefKeys {
    public static final PrefKey f59a;
    public static final PrefKey f60b;
    public static final PrefKey f61c;
    public static final PrefKey f62d = ((PrefKey) f60b.a("current_cap"));
    public static final PrefKey f63e = ((PrefKey) f60b.a("expiry"));
    public static final PrefKey f64f = ((PrefKey) f60b.a("friendly_name_to_rewrite"));
    public static final PrefKey f65g = ((PrefKey) f60b.a("message_rewrite_rule"));
    public static final PrefKey f66h = ((PrefKey) f60b.a("mqtt_rewrite_rules"));
    public static final PrefKey f67i = ((PrefKey) f60b.a("user_saved_mode"));
    public static final PrefKey f68j = ((PrefKey) f60b.a("user_paid_mode"));
    public static final PrefKey f69k = ((PrefKey) f60b.a("ignore_zero_deltas"));
    public static final PrefKey f70l = ((PrefKey) f60b.a("last_active_state_pref"));
    public static final PrefKey f71m = ((PrefKey) f60b.a("composer_button_tooltip"));

    static {
        PrefKey prefKey = (PrefKey) ZeroPrefKeys.b.a("capping/");
        f59a = prefKey;
        prefKey = (PrefKey) prefKey.a("messages/");
        f60b = prefKey;
        f61c = (PrefKey) prefKey.a("total_cap");
    }
}
