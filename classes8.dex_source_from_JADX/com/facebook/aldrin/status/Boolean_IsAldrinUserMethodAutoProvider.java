package com.facebook.aldrin.status;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: launch_response */
public class Boolean_IsAldrinUserMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m12186b(InjectorLike injectorLike) {
        return AldrinStatusModule.b(AldrinUserStatusManager.a(injectorLike));
    }

    public Object get() {
        return AldrinStatusModule.b(AldrinUserStatusManager.a(this));
    }
}
