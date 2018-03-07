package com.facebook.messaging.quickcam;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: deserializePlatformItem */
public class Boolean_IsAndroidCameraTakePictureEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m16468b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1025, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1025, false));
    }
}
