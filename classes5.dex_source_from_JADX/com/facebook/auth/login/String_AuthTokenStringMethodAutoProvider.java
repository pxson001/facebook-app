package com.facebook.auth.login;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.AbstractProvider;

/* compiled from: surveyTracking */
public class String_AuthTokenStringMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return LoginModule.a(LoggedInUserSessionManager.a(this));
    }
}
