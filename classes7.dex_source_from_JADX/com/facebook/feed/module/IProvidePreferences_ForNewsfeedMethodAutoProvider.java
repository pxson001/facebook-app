package com.facebook.feed.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.provider.IProvidePreferences;

/* compiled from: album_privacy_selector_opened */
public class IProvidePreferences_ForNewsfeedMethodAutoProvider extends AbstractProvider<IProvidePreferences> {
    public Object get() {
        return NewsFeedModule.f();
    }

    public static IProvidePreferences m22856a(InjectorLike injectorLike) {
        return NewsFeedModule.f();
    }
}
