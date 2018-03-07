package com.facebook.account.recovery.constants;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: local_serp_impression */
public class AccountRecoveryPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f10215a = ((PrefKey) SharedPrefKeys.d.a("ar_device_data"));

    public final ImmutableSet<PrefKey> m12006b() {
        return ImmutableSet.of(f10215a);
    }
}
