package com.facebook.feed.environment.impl;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: newsfeed_db */
public class CanFollowUserImpl implements CanFollowUser {
    private final Lazy<FriendingClient> f12284a;
    private final DefaultAndroidThreadUtil f12285b;
    public final FriendingExceptionHandler f12286c;

    public static CanFollowUserImpl m18294b(InjectorLike injectorLike) {
        return new CanFollowUserImpl(IdBasedLazy.m1808a(injectorLike, 2073), DefaultAndroidThreadUtil.m1646b(injectorLike), FriendingExceptionHandler.m18298b(injectorLike));
    }

    @Inject
    public CanFollowUserImpl(Lazy<FriendingClient> lazy, AndroidThreadUtil androidThreadUtil, FriendingExceptionHandler friendingExceptionHandler) {
        this.f12284a = lazy;
        this.f12285b = androidThreadUtil;
        this.f12286c = friendingExceptionHandler;
    }

    public final void mo2436a(String str, String str2) {
        m18293a(((FriendingClient) this.f12284a.get()).m31443a(str, SubscribeLocation.valueOf(str2)));
    }

    public static CanFollowUserImpl m18292a(InjectorLike injectorLike) {
        return m18294b(injectorLike);
    }

    public final void mo2444b(String str, String str2) {
        m18293a(((FriendingClient) this.f12284a.get()).m31445a(str, ActorUnsubscribeInputData.SubscribeLocation.valueOf(str2)));
    }

    private void m18293a(ListenableFuture<Void> listenableFuture) {
        this.f12285b.m1651a((ListenableFuture) listenableFuture, new 1(this));
    }
}
