package com.facebook.friends;

import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.model.PersonYouMayKnow;
import com.google.common.base.Function;
import java.util.List;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$4 implements Function<FetchPeopleYouMayKnowResult, List<PersonYouMayKnow>> {
    final /* synthetic */ FriendingClient f10547a;

    FriendingClient$4(FriendingClient friendingClient) {
        this.f10547a = friendingClient;
    }

    public Object apply(Object obj) {
        FetchPeopleYouMayKnowResult fetchPeopleYouMayKnowResult = (FetchPeopleYouMayKnowResult) obj;
        synchronized (this) {
            this.f10547a.a = fetchPeopleYouMayKnowResult.f10648b;
        }
        return fetchPeopleYouMayKnowResult.f10647a;
    }
}
