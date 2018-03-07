package com.facebook.analytics;

import com.facebook.inject.AbstractProvider;

/* compiled from: work_sso_nonce */
public class Boolean_AnalyticsBackgroundStateMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return AnalyticsClientModule.a(NavigationLogger.a(this));
    }
}
