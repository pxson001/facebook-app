package com.facebook.messaging.neue.shared;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: is_admin */
public class NeuePrefKeys implements IHaveNonCriticalKeysToClear, IHavePrivacyCriticalKeysToClear {
    public static NeuePrefKeys m13096a(InjectorLike injectorLike) {
        return new NeuePrefKeys();
    }

    public final ImmutableSet<PrefKey> m13098b() {
        return ImmutableSet.of(MessagingPrefKeys.v, MessagingPrefKeys.u, MessagingPrefKeys.t, MessagingPrefKeys.s, MessagingPrefKeys.r, MessagingPrefKeys.q, new PrefKey[]{MessagingPrefKeys.p, MessagingPrefKeys.o, MessagingPrefKeys.x});
    }

    public final ImmutableSet<PrefKey> m13097a() {
        return RegularImmutableSet.a;
    }
}
