package com.facebook.feed.util.injection;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: meme_category */
public class FeedClientSideInjectionModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static FeedClientSideInjectionTool getInstanceForTest_FeedClientSideInjectionTool(FbInjector fbInjector) {
        return FeedClientSideInjectionTool.m16603a((InjectorLike) fbInjector);
    }
}
