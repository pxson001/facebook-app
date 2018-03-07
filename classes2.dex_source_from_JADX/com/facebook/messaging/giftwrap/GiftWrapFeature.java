package com.facebook.messaging.giftwrap;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: mPrivateFlags2 */
public class GiftWrapFeature {
    private final FbSharedPreferences f15480a;
    public final GatekeeperStoreImpl f15481b;

    public static GiftWrapFeature m22045b(InjectorLike injectorLike) {
        return new GiftWrapFeature(FbSharedPreferencesImpl.m1826a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public GiftWrapFeature(FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f15480a = fbSharedPreferences;
        this.f15481b = gatekeeperStoreImpl;
    }
}
