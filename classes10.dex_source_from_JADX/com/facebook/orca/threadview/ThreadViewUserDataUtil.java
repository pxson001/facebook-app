package com.facebook.orca.threadview;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/commerce_merchant_subscriptions */
public class ThreadViewUserDataUtil {
    private final UserCache f8052a;

    public static ThreadViewUserDataUtil m7949a(InjectorLike injectorLike) {
        return new ThreadViewUserDataUtil(UserCache.a(injectorLike));
    }

    @Inject
    public ThreadViewUserDataUtil(UserCache userCache) {
        this.f8052a = userCache;
    }

    @Nullable
    public final User m7950a(@Nullable Result result, @Nullable ThreadKey threadKey) {
        if (result != null && result.m7330b()) {
            return result.f7612b;
        }
        if (!ThreadKey.b(threadKey) && !ThreadKey.g(threadKey)) {
            return null;
        }
        return this.f8052a.a(UserKey.b(Long.toString(threadKey.d)));
    }
}
