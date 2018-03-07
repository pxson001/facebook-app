package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;

/* compiled from: surveySponsoredData */
public class Boolean_IsMeUserAMessengerOnlyUserMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return LoggedInUserModule.b(User_LoggedInUserMethodAutoProvider.b(this));
    }
}
