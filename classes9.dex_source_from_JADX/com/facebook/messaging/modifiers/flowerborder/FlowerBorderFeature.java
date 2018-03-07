package com.facebook.messaging.modifiers.flowerborder;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: key_templated_str */
public class FlowerBorderFeature {
    public final FbSharedPreferences f12267a;
    private final GatekeeperStoreImpl f12268b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FBSoundUtil> f12269c = UltralightRuntime.b;

    public static FlowerBorderFeature m12736a(InjectorLike injectorLike) {
        FlowerBorderFeature flowerBorderFeature = new FlowerBorderFeature((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        flowerBorderFeature.f12269c = IdBasedSingletonScopeProvider.b(injectorLike, 10994);
        return flowerBorderFeature;
    }

    @Inject
    public FlowerBorderFeature(FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12267a = fbSharedPreferences;
        this.f12268b = gatekeeperStoreImpl;
    }

    public final boolean m12738b() {
        return this.f12268b.a(223, false);
    }

    public final boolean m12739c() {
        return this.f12268b.a(224, false);
    }

    public final boolean m12737a(Message message) {
        return m12739c() && message.O;
    }
}
