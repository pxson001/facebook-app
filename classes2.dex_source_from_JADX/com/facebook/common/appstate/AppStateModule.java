package com.facebook.common.appstate;

import com.facebook.common.appstate.AppStateManager.FloatingWindowListener;
import com.facebook.common.appstate.AppStateManager.MyActivityListener;
import com.facebook.common.appstate.handler.IsAppInBackground;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: succeed */
public class AppStateModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsAppInBackground
    @ProviderMethod
    public static Boolean m6468c(AppStateManager appStateManager) {
        return Boolean.valueOf(appStateManager.m2262j());
    }

    @ProviderMethod
    @Singleton
    static MyActivityListener m6466a(AppStateManager appStateManager) {
        return appStateManager.f1157w;
    }

    @ProviderMethod
    @Singleton
    static FloatingWindowListener m6467b(AppStateManager appStateManager) {
        return appStateManager.f1158x;
    }
}
