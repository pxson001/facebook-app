package com.facebook.intent.feed.module;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: mConnectionConstraint */
public class FeedIntentModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static IFeedIntentBuilder getInstanceForTest_IFeedIntentBuilder(FbInjector fbInjector) {
        return (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector);
    }
}
