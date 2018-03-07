package com.facebook.auth.userscope;

import android.annotation.SuppressLint;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: wirehog_sample */
public class UserScopeModule extends AbstractLibraryModule {
    @SuppressLint({"NontrivialConfigureMethod"})
    protected void configure() {
        this.mBinder.m1348b(UserScope.class).mo198a(new UserScopeMethodAutoProvider());
        Object userScope = new UserScope();
        bindScope(UserScoped.class, userScope);
        bind(UserScope.class).mo199a(userScope);
    }

    @ProviderMethod
    static UserScope m1450a() {
        throw Assertions.m5465a();
    }
}
