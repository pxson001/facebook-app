package com.facebook.auth.module;

import com.facebook.auth.credentials.UserTokenCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.AbstractProvider;

/* compiled from: graphOpenGraphActionPublish */
public class UserTokenCredentialsMethodAutoProvider extends AbstractProvider<UserTokenCredentials> {
    public Object get() {
        return LoggedInUserModule.a(LoggedInUserSessionManager.a(this));
    }
}
