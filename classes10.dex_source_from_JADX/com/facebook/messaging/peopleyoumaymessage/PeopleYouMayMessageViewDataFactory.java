package com.facebook.messaging.peopleyoumaymessage;

import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: removeMember */
public class PeopleYouMayMessageViewDataFactory {
    private static PeopleYouMayMessageViewDataFactory m3381a() {
        return new PeopleYouMayMessageViewDataFactory();
    }

    @Inject
    PeopleYouMayMessageViewDataFactory() {
    }

    public static PeopleYouMayMessageViewData m3380a(PeopleYouMayMessageData peopleYouMayMessageData) {
        if (peopleYouMayMessageData == null) {
            return null;
        }
        return new PeopleYouMayMessageViewData(peopleYouMayMessageData.f3474a, peopleYouMayMessageData.f3475b, peopleYouMayMessageData.f3477d, peopleYouMayMessageData.f3478e);
    }

    public static PeopleYouMayMessageViewDataFactory m3382a(InjectorLike injectorLike) {
        return m3381a();
    }
}
