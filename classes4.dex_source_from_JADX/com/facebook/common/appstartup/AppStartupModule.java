package com.facebook.common.appstartup;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.feed.annotations.IsAppStartupDone;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: month */
public class AppStartupModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAppStartupDone
    public static Boolean m7816a(AppStartupTracker appStartupTracker) {
        boolean z = (appStartupTracker.c && ((AppStateManager) appStartupTracker.b.get()).l()) ? false : true;
        return Boolean.valueOf(z);
    }
}
