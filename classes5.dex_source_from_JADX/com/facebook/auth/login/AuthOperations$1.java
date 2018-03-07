package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$1 implements Callable<AuthenticationResult> {
    final /* synthetic */ AuthenticationResult f2265a;
    final /* synthetic */ AuthOperations f2266b;

    AuthOperations$1(AuthOperations authOperations, AuthenticationResult authenticationResult) {
        this.f2266b = authOperations;
        this.f2265a = authenticationResult;
    }

    public Object call() {
        return this.f2265a;
    }
}
