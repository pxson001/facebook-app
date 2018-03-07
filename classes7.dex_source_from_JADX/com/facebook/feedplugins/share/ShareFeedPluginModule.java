package com.facebook.feedplugins.share;

import com.facebook.feed.analytics.IsStorySharingAnalyticsEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: removeClippedSubviews */
public class ShareFeedPluginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsStorySharingAnalyticsEnabled
    static Boolean m5762a() {
        return Boolean.valueOf(false);
    }
}
