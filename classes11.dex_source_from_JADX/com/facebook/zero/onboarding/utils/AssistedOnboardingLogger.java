package com.facebook.zero.onboarding.utils;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: minimum_price */
public class AssistedOnboardingLogger {
    private final Lazy<AnalyticsLogger> f5389a;

    public static AssistedOnboardingLogger m6627b(InjectorLike injectorLike) {
        return new AssistedOnboardingLogger(IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    @Inject
    public AssistedOnboardingLogger(Lazy<AnalyticsLogger> lazy) {
        this.f5389a = lazy;
    }

    public final void m6628a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "assisted_onboarding";
        ((AnalyticsLogger) this.f5389a.get()).a(honeyClientEvent);
    }
}
