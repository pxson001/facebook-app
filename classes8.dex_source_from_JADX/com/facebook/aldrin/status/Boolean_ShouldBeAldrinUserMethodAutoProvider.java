package com.facebook.aldrin.status;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: launch_media_gallery */
public class Boolean_ShouldBeAldrinUserMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m12187b(InjectorLike injectorLike) {
        return AldrinStatusModule.a(AldrinUserStatusManager.a(injectorLike));
    }

    public Object get() {
        return AldrinStatusModule.a(AldrinUserStatusManager.a(this));
    }
}
