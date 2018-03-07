package com.facebook.common.random;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.security.SecureRandom;
import java.util.Random;

@InjectorModule
/* compiled from: viewer_notification_subscription_level */
public class RandomModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @InsecureRandom
    static Random m2104a() {
        return new Random();
    }

    @ProviderMethod
    @FixedSecureRandom
    static SecureRandom m2103a(SecureRandomFix secureRandomFix) {
        secureRandomFix.m23042a();
        return new SecureRandom();
    }
}
