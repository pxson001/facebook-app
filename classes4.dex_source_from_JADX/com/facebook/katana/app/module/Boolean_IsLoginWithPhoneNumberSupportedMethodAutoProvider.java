package com.facebook.katana.app.module;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: two_phase_send */
public class Boolean_IsLoginWithPhoneNumberSupportedMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m1028a(InjectorLike injectorLike) {
        return MainProcessModule.a(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public Object get() {
        return MainProcessModule.a(Boolean_IsWorkBuildMethodAutoProvider.a(this));
    }
}
