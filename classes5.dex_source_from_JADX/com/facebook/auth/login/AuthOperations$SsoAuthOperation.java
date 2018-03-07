package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticateSsoMethod$Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$SsoAuthOperation implements Callable<AuthenticationResult> {
    final /* synthetic */ AuthOperations f2283a;
    private final String f2284b;

    public /* synthetic */ Object call() {
        return m3174a();
    }

    public AuthOperations$SsoAuthOperation(AuthOperations authOperations, String str) {
        this.f2283a = authOperations;
        this.f2284b = str;
    }

    public final AuthenticationResult m3174a() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2283a.f.get()).a(this.f2283a.e, new AuthenticateSsoMethod$Params(this.f2284b, this.f2283a.b.a(AuthPrefKeys.f, null), ((Boolean) this.f2283a.i.get()).booleanValue()), CallerContext.b(getClass(), "AuthOperations"));
    }
}
