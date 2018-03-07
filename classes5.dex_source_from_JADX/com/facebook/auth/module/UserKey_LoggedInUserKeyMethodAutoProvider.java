package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.UserKey;

/* compiled from: supports_suggestions */
public class UserKey_LoggedInUserKeyMethodAutoProvider extends AbstractProvider<UserKey> {
    public static UserKey m3199b(InjectorLike injectorLike) {
        return LoggedInUserModule.a(User_LoggedInUserMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.a(User_LoggedInUserMethodAutoProvider.b(this));
    }
}
