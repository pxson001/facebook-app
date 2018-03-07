package com.facebook.common.appstartup;

import com.facebook.inject.AbstractProvider;

/* compiled from: moto_active_display_on */
public class Boolean_IsAppStartupDoneMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return AppStartupModule.m7816a(AppStartupTracker.a(this));
    }
}
