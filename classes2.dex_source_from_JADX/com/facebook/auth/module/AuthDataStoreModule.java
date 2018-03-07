package com.facebook.auth.module;

import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.user.model.User;

@InjectorModule
/* compiled from: t_ms */
public class AuthDataStoreModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LoggedInUser
    static User m5749a(LoggedInUserSessionManager loggedInUserSessionManager) {
        return loggedInUserSessionManager.m2523c();
    }
}
