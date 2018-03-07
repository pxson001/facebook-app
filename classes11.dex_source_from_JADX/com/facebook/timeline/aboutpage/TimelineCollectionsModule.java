package com.facebook.timeline.aboutpage;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.feed.protocol.UpdateTimelineAppCollectionMethod;
import com.facebook.feed.server.UpdateCollectionServiceHandler;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved.common.sync.SavedEventHandler;
import com.facebook.timeline.aboutpage.annotations.ForTimelineCollections;
import com.facebook.timeline.aboutpage.annotations.IsNativeCollectionsSubscribeEnabled;
import com.facebook.timeline.aboutpage.annotations.IsTheWhoEnabled;
import com.facebook.timeline.aboutpage.service.CollectionsCacheServiceHandler;
import com.facebook.timeline.aboutpage.service.TimelineCollectionsQueue;
import javax.inject.Provider;

@InjectorModule
/* compiled from: NEWSFEED */
public class TimelineCollectionsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsNativeCollectionsSubscribeEnabled
    public static Boolean m13832a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsTheWhoEnabled
    static Boolean m13833b() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @ForTimelineCollections
    static UpdateCollectionServiceHandler m13831a(Lazy<SavedEventHandler> lazy, FbSharedPreferences fbSharedPreferences, Provider<SingleMethodRunner> provider, Provider<UpdateTimelineAppCollectionMethod> provider2) {
        return new UpdateCollectionServiceHandler(lazy, fbSharedPreferences, provider, provider2, "update_timeline_app_collection_in_timeline");
    }

    @ProviderMethod
    @ContextScoped
    @TimelineCollectionsQueue
    static BlueServiceHandler m13830a(CollectionsCacheServiceHandler collectionsCacheServiceHandler, UpdateCollectionServiceHandler updateCollectionServiceHandler) {
        return new FilterChainLink(collectionsCacheServiceHandler, new FilterChainLink(updateCollectionServiceHandler, new TerminatingHandler()));
    }
}
