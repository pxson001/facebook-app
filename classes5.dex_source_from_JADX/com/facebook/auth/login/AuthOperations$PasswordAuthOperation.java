package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticateMethod.Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$PasswordAuthOperation implements Callable<AuthenticationResult> {
    final /* synthetic */ AuthOperations f2281a;
    private final PasswordCredentials f2282b;

    public /* synthetic */ Object call() {
        return m3173a();
    }

    public AuthOperations$PasswordAuthOperation(AuthOperations authOperations, PasswordCredentials passwordCredentials) {
        this.f2281a = authOperations;
        this.f2282b = passwordCredentials;
    }

    public final AuthenticationResult m3173a() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2281a.f.get()).a(this.f2281a.d, new Params(this.f2282b, this.f2281a.b.a(AuthPrefKeys.f, null), null, ((Boolean) this.f2281a.i.get()).booleanValue(), null), CallerContext.b(getClass(), "AuthOperations"));
    }
}
