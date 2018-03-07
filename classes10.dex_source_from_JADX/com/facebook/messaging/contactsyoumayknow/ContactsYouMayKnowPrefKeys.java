package com.facebook.messaging.contactsyoumayknow;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: switch_to_dbl_with_pin */
public class ContactsYouMayKnowPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f2140a = ((PrefKey) SharedPrefKeys.c.a("cymk_people_notice_accepted"));

    public final ImmutableSet<PrefKey> m1939a() {
        return ImmutableSet.of(f2140a);
    }
}
