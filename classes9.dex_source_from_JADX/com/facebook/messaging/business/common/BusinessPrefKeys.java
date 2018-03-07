package com.facebook.messaging.business.common;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: nickname_editor */
public class BusinessPrefKeys {
    public static final PrefKey f8672a;
    public static final PrefKey f8673b;
    public static final PrefKey f8674c;
    public static final PrefKey f8675d;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("businesses_on_messenger/");
        f8672a = prefKey;
        f8673b = (PrefKey) prefKey.a("agent_terms_accepted");
        prefKey = (PrefKey) f8672a.a("commerce");
        f8674c = prefKey;
        f8675d = (PrefKey) prefKey.a("wifi_in_range_time_stamp");
    }
}
