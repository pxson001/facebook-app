package com.facebook.http.debug;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: display name */
public class NetworkStatsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static NetworkStats getInstanceForTest_NetworkStats(FbInjector fbInjector) {
        return NetworkStats.a(fbInjector);
    }
}
