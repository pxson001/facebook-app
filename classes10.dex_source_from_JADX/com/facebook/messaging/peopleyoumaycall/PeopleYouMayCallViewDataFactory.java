package com.facebook.messaging.peopleyoumaycall;

import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: reportGroup */
public class PeopleYouMayCallViewDataFactory {
    private final PeopleYouMayCallViewHelper f3461a;

    private static PeopleYouMayCallViewDataFactory m3345b(InjectorLike injectorLike) {
        return new PeopleYouMayCallViewDataFactory(PeopleYouMayCallViewHelper.m3347b(injectorLike));
    }

    @Inject
    PeopleYouMayCallViewDataFactory(PeopleYouMayCallViewHelper peopleYouMayCallViewHelper) {
        this.f3461a = peopleYouMayCallViewHelper;
    }

    public static PeopleYouMayCallViewDataFactory m3344a(InjectorLike injectorLike) {
        return m3345b(injectorLike);
    }
}
