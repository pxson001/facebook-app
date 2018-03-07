package com.facebook.api.feed;

import com.facebook.api.feed.annotation.FeedbackMemoryCacheSize;
import com.facebook.api.feed.annotation.StoryMemoryCacheSize;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: sandbox */
public class FeedMemoryCacheModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @FeedbackMemoryCacheSize
    @ProviderMethod
    static Integer m10575a() {
        return Integer.valueOf(200);
    }

    @StoryMemoryCacheSize
    @ProviderMethod
    public static Integer m10576b() {
        return Integer.valueOf(100);
    }
}
