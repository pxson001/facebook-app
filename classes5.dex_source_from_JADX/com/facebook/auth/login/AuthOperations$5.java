package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.ConfirmedMessengerCredentials;
import com.facebook.auth.protocol.LoginBypassWithMessengerCredentialsParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$5 implements Callable<AuthenticationResult> {
    final /* synthetic */ ConfirmedMessengerCredentials f2276a;
    final /* synthetic */ AuthOperations f2277b;

    AuthOperations$5(AuthOperations authOperations, ConfirmedMessengerCredentials confirmedMessengerCredentials) {
        this.f2277b = authOperations;
        this.f2276a = confirmedMessengerCredentials;
    }

    public Object call() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2277b.f.get()).a(this.f2277b.l, new LoginBypassWithMessengerCredentialsParams(this.f2276a, ((Boolean) this.f2277b.i.get()).booleanValue(), this.f2277b.b.a(AuthPrefKeys.f, null)), CallerContext.b(getClass(), "AuthOperations"));
    }
}
