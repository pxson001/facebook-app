package com.facebook.messaging.payment.awareness;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: invitable */
public class GroupCommerceAwarenessNuxController {
    public final Provider<Boolean> f12803a;
    public final QeAccessor f12804b;
    public final FbSharedPreferences f12805c;

    public static GroupCommerceAwarenessNuxController m13141a(InjectorLike injectorLike) {
        return new GroupCommerceAwarenessNuxController(IdBasedProvider.a(injectorLike, 4181), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public GroupCommerceAwarenessNuxController(Provider<Boolean> provider, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f12803a = provider;
        this.f12804b = qeAccessor;
        this.f12805c = fbSharedPreferences;
    }
}
