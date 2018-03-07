package com.facebook.confirmation.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: encryptBuffer cannot be smaller than  */
public class AccountConfirmationPrefKeys {
    public static final PrefKey f13078a;
    public static final PrefKey f13079b = ((PrefKey) f13086i.a("codes_attempted"));
    public static final PrefKey f13080c = ((PrefKey) f13086i.a("codes_to_retry"));
    public static final PrefKey f13081d = ((PrefKey) f13086i.a("num_reads"));
    public static final PrefKey f13082e = ((PrefKey) f13086i.a("sms_confirmation_reader_pointer"));
    public static final PrefKey f13083f = ((PrefKey) f13086i.a("pending_contactpoints/"));
    public static final PrefKey f13084g = ((PrefKey) f13086i.a("email_oauth_last_attempt_time"));
    public static final PrefKey f13085h = ((PrefKey) f13086i.a("email_oauth_attempt_count/"));
    private static final PrefKey f13086i;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("account_confirmation/");
        f13086i = prefKey;
        f13078a = (PrefKey) prefKey.a("read_sms_last_scan_time");
    }
}
