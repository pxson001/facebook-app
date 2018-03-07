package com.facebook.debug.feed;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: 장곡 */
public class DebugFeedModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static DebugFeedConfig getInstanceForTest_DebugFeedConfig(FbInjector fbInjector) {
        return DebugFeedConfig.a(fbInjector);
    }
}
