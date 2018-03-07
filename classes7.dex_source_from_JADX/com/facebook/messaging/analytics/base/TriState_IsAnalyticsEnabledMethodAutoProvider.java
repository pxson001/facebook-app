package com.facebook.messaging.analytics.base;

import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: onSelectCapture */
public class TriState_IsAnalyticsEnabledMethodAutoProvider extends AbstractProvider<TriState> {
    private static TriState m9417b(InjectorLike injectorLike) {
        return MessagingAnalyticsBaseModule.m9414a(User_LoggedInUserMethodAutoProvider.b(injectorLike), Boolean_IsAnalyticsEnabledGkGatekeeperAutoProvider.m9413b(injectorLike));
    }

    public Object get() {
        return MessagingAnalyticsBaseModule.m9414a(User_LoggedInUserMethodAutoProvider.b(this), Boolean_IsAnalyticsEnabledGkGatekeeperAutoProvider.m9413b(this));
    }
}
