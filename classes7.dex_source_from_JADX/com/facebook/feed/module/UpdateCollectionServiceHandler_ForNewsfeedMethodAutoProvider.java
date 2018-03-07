package com.facebook.feed.module;

import com.facebook.feed.server.UpdateCollectionServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: album_description_text_entered */
public class UpdateCollectionServiceHandler_ForNewsfeedMethodAutoProvider extends AbstractProvider<UpdateCollectionServiceHandler> {
    public Object get() {
        return NewsFeedModule.a(IdBasedLazy.a(this, 10403), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedSingletonScopeProvider.a(this, 2289), IdBasedProvider.a(this, 5895));
    }
}
