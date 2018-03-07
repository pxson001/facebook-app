package com.facebook.privacy;

import com.facebook.api.feedcache.db.FeedDbCacheServiceHandler;
import com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.privacy.gating.IsDefaultPostPrivacyEnabled;
import com.facebook.privacy.service.PrivacyCacheServiceHandler;
import com.facebook.privacy.service.PrivacyDataQueue;
import com.facebook.privacy.service.PrivacyServiceHandler;

@InjectorModule
/* compiled from: fetch_group_members_to_mentions */
public final class PrivacyModule extends AbstractLibraryModule {
    protected final void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsDefaultPostPrivacyEnabled
    public static TriState m22542a(FbSharedPreferences fbSharedPreferences) {
        if (fbSharedPreferences.a(PrivacyPrefKeys.m, false)) {
            return TriState.YES;
        }
        return fbSharedPreferences.b(PrivacyPrefKeys.n);
    }

    @ProviderMethod
    @PrivacyDataQueue
    @ContextScoped
    static BlueServiceHandler m22543a(FeedMemoryCacheServiceHandler feedMemoryCacheServiceHandler, FeedDbCacheServiceHandler feedDbCacheServiceHandler, PrivacyCacheServiceHandler privacyCacheServiceHandler, PrivacyServiceHandler privacyServiceHandler) {
        return new FilterChainLink(feedMemoryCacheServiceHandler, new FilterChainLink(privacyCacheServiceHandler, new FilterChainLink(feedDbCacheServiceHandler, privacyServiceHandler)));
    }
}
