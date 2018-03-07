package com.facebook.auth.module;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;

/* compiled from: t_ms_gd */
public class User_LoggedInUserMethodAutoProvider extends AbstractProvider<User> {
    public static User m5748b(InjectorLike injectorLike) {
        return AuthDataStoreModule.m5749a(LoggedInUserSessionManager.m2511a(injectorLike));
    }

    public Object get() {
        return AuthDataStoreModule.m5749a(LoggedInUserSessionManager.m2511a((InjectorLike) this));
    }
}
