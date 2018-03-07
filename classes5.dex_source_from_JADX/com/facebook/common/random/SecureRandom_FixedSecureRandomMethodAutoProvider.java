package com.facebook.common.random;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import java.security.SecureRandom;

/* compiled from: show_active_education */
public class SecureRandom_FixedSecureRandomMethodAutoProvider extends AbstractProvider<SecureRandom> {
    public static SecureRandom m3843b(InjectorLike injectorLike) {
        return RandomModule.a(SecureRandomFix.a(injectorLike));
    }

    public Object get() {
        return RandomModule.a(SecureRandomFix.a(this));
    }
}
