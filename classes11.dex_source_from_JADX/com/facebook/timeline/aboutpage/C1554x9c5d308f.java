package com.facebook.timeline.aboutpage;

import com.facebook.feed.server.UpdateCollectionServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: NETEGO_PHOTO_STORY */
public class C1554x9c5d308f extends AbstractProvider<UpdateCollectionServiceHandler> {
    public static UpdateCollectionServiceHandler m13834b(InjectorLike injectorLike) {
        return TimelineCollectionsModule.m13831a(IdBasedLazy.a(injectorLike, 10403), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedProvider.a(injectorLike, 5895));
    }

    public Object get() {
        return TimelineCollectionsModule.m13831a(IdBasedLazy.a(this, 10403), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedSingletonScopeProvider.a(this, 2289), IdBasedProvider.a(this, 5895));
    }
}
