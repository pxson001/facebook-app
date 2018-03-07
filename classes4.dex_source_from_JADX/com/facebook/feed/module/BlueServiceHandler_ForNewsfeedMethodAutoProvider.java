package com.facebook.feed.module;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: profileFbid */
public class BlueServiceHandler_ForNewsfeedMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    public static BlueServiceHandler m4685b(InjectorLike injectorLike) {
        return NewsFeedModule.a(IdBasedLazy.a(injectorLike, 6056), IdBasedLazy.a(injectorLike, 6052), IdBasedLazy.a(injectorLike, 4830), IdBasedLazy.a(injectorLike, 5271), IdBasedSingletonScopeProvider.b(injectorLike, 3116), IdBasedSingletonScopeProvider.b(injectorLike, 859), IdBasedSingletonScopeProvider.b(injectorLike, 235), IdBasedLazy.a(injectorLike, 1713), IdBasedSingletonScopeProvider.b(injectorLike, 242), IdBasedLazy.a(injectorLike, 1307));
    }

    public Object get() {
        return NewsFeedModule.a(IdBasedLazy.a(this, 6056), IdBasedLazy.a(this, 6052), IdBasedLazy.a(this, 4830), IdBasedLazy.a(this, 5271), IdBasedSingletonScopeProvider.b(this, 3116), IdBasedSingletonScopeProvider.b(this, 859), IdBasedSingletonScopeProvider.b(this, 235), IdBasedLazy.a(this, 1713), IdBasedSingletonScopeProvider.b(this, 242), IdBasedLazy.a(this, 1307));
    }
}
