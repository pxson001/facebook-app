package com.facebook.friends;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.util.event.RefreshTriggerEvents.FriendRequestEvent;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$13 extends AbstractDisposableFutureCallback<Object> {
    final /* synthetic */ FriendingClient f10542a;

    FriendingClient$13(FriendingClient friendingClient) {
        this.f10542a = friendingClient;
    }

    public final void m16713a(Object obj) {
        this.f10542a.p.a(new FriendRequestEvent());
    }

    public final void m16714a(Throwable th) {
    }
}
