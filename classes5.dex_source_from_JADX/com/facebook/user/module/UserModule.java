package com.facebook.user.module;

import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.user.model.User;

@InjectorModule
/* compiled from: com.instagram.android */
public class UserModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static User getInstanceForTest_User(FbInjector fbInjector) {
        return User_LoggedInUserMethodAutoProvider.b(fbInjector);
    }
}
