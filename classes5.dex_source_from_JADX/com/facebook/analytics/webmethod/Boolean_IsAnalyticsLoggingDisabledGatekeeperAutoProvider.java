package com.facebook.analytics.webmethod;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: throwbackPromotionActionLinks */
public class Boolean_IsAnalyticsLoggingDisabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(562, false));
    }
}
