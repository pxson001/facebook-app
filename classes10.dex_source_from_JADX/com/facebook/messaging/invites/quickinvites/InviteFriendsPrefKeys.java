package com.facebook.messaging.invites.quickinvites;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: selected_locale */
public class InviteFriendsPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f2994a;
    public static final PrefKey f2995b = ((PrefKey) f2997d.a("upsell_decline_count"));
    public static final PrefKey f2996c = ((PrefKey) f2997d.a("sent_invites"));
    private static final PrefKey f2997d;

    public static InviteFriendsPrefKeys m2978a(InjectorLike injectorLike) {
        return new InviteFriendsPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("invite_friends/");
        f2997d = prefKey;
        f2994a = (PrefKey) prefKey.a("last_upsell_decline_ms");
    }

    public final ImmutableSet<PrefKey> m2979b() {
        return ImmutableSet.of(f2997d);
    }
}
