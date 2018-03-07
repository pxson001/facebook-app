package com.facebook.orca.threadview;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.orca.threadview.annotations.IsRateLimitTooltipEnabled;

@InjectorModule
/* compiled from: media_tray_nux_dismissed */
public class ThreadViewModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsRateLimitTooltipEnabled
    static Boolean m7873a() {
        return Boolean.valueOf(false);
    }
}
