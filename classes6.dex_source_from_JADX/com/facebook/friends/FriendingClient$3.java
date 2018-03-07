package com.facebook.friends;

import com.facebook.friends.model.FetchFriendRequestResult;
import com.facebook.friends.model.FriendRequest;
import com.google.common.base.Function;
import java.util.List;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$3 implements Function<FetchFriendRequestResult, List<FriendRequest>> {
    final /* synthetic */ FriendingClient f10546a;

    FriendingClient$3(FriendingClient friendingClient) {
        this.f10546a = friendingClient;
    }

    public Object apply(Object obj) {
        FetchFriendRequestResult fetchFriendRequestResult = (FetchFriendRequestResult) obj;
        synchronized (this) {
            this.f10546a.b = fetchFriendRequestResult.f10646b;
        }
        return fetchFriendRequestResult.f10645a;
    }
}
