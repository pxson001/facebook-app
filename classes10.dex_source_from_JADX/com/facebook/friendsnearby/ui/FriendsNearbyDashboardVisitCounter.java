package com.facebook.friendsnearby.ui;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friendsnearby.entitycards.FriendsNearbyPrefKeys;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: YOUR_SALE_POSTS */
public class FriendsNearbyDashboardVisitCounter implements IHaveNonCriticalKeysToClear {
    private static final PrefKey f20822a;
    public static final PrefKey f20823b;
    private static FriendsNearbyDashboardVisitCounter f20824d;
    private static final Object f20825e = new Object();
    public final FbSharedPreferences f20826c;

    private static FriendsNearbyDashboardVisitCounter m21727b(InjectorLike injectorLike) {
        return new FriendsNearbyDashboardVisitCounter((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) FriendsNearbyPrefKeys.f20454a.a("visit_counters/");
        f20822a = prefKey;
        f20823b = (PrefKey) prefKey.a("to_list");
    }

    @Inject
    public FriendsNearbyDashboardVisitCounter(FbSharedPreferences fbSharedPreferences) {
        this.f20826c = fbSharedPreferences;
    }

    public final int m21729c() {
        return this.f20826c.a(f20823b, 0);
    }

    public final ImmutableSet<PrefKey> m21728a() {
        return ImmutableSet.of(f20823b);
    }

    public static FriendsNearbyDashboardVisitCounter m21726a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsNearbyDashboardVisitCounter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20825e) {
                FriendsNearbyDashboardVisitCounter friendsNearbyDashboardVisitCounter;
                if (a2 != null) {
                    friendsNearbyDashboardVisitCounter = (FriendsNearbyDashboardVisitCounter) a2.a(f20825e);
                } else {
                    friendsNearbyDashboardVisitCounter = f20824d;
                }
                if (friendsNearbyDashboardVisitCounter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21727b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20825e, b3);
                        } else {
                            f20824d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsNearbyDashboardVisitCounter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
