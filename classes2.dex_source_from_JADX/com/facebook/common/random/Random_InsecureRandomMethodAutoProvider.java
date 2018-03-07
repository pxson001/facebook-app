package com.facebook.common.random;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import java.util.Random;

/* compiled from: viewer_push_subscription_level */
public class Random_InsecureRandomMethodAutoProvider extends AbstractProvider<Random> {
    public Object get() {
        return RandomModule.m2104a();
    }

    public static Random m2102a(InjectorLike injectorLike) {
        return RandomModule.m2104a();
    }
}
