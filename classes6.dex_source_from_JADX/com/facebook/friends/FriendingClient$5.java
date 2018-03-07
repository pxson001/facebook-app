package com.facebook.friends;

import com.facebook.friends.model.PersonYouMayKnow;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
public class FriendingClient$5 implements Function<PersonYouMayKnow, String> {
    final /* synthetic */ FriendingClient f10548a;

    public FriendingClient$5(FriendingClient friendingClient) {
        this.f10548a = friendingClient;
    }

    public Object apply(@Nullable Object obj) {
        return String.valueOf(((PersonYouMayKnow) obj).mo1048a());
    }
}
