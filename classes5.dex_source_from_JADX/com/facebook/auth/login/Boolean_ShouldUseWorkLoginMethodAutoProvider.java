package com.facebook.auth.login;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tag_prefill_completed */
public class Boolean_ShouldUseWorkLoginMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m3175b(InjectorLike injectorLike) {
        return Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike);
    }

    public Object get() {
        return Boolean_IsWorkBuildMethodAutoProvider.a(this);
    }
}
