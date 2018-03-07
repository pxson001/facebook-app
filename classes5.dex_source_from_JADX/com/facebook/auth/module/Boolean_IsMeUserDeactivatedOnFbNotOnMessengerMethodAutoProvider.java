package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: surveyResponse */
public class Boolean_IsMeUserDeactivatedOnFbNotOnMessengerMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m3197b(InjectorLike injectorLike) {
        return LoggedInUserModule.c(User_LoggedInUserMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.c(User_LoggedInUserMethodAutoProvider.b(this));
    }
}
