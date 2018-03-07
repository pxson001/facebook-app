package com.facebook.facedetection.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: null mExoPlayer in onRenderers */
public class Boolean_IsFaceDetectionEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m15585b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(380, true));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(380, true));
    }
}
