package com.facebook.messaging.customthreads;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: mediaUrl */
public class CustomThreadsPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f10266a;
    private static final PrefKey f10267b;

    public static CustomThreadsPrefKeys m10874a(InjectorLike injectorLike) {
        return new CustomThreadsPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("customthreads/");
        f10267b = prefKey;
        f10266a = (PrefKey) prefKey.a("likenuxanchor/");
    }

    public static PrefKey m10875a(ThreadKey threadKey) {
        return (PrefKey) f10266a.a(threadKey.toString());
    }

    public final ImmutableSet<PrefKey> m10876a() {
        return ImmutableSet.of(f10266a);
    }
}
