package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticateDBLMethod$Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$DblAuthOperation implements Callable<AuthenticationResult> {
    final /* synthetic */ AuthOperations f2279a;
    private final DeviceBasedLoginCredentials f2280b;

    public /* synthetic */ Object call() {
        return m3172a();
    }

    public AuthOperations$DblAuthOperation(AuthOperations authOperations, DeviceBasedLoginCredentials deviceBasedLoginCredentials) {
        this.f2279a = authOperations;
        this.f2280b = deviceBasedLoginCredentials;
    }

    public final AuthenticationResult m3172a() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2279a.f.get()).a((ApiMethod) this.f2279a.q.get(), new AuthenticateDBLMethod$Params(this.f2280b, this.f2279a.b.a(AuthPrefKeys.f, null), null, ((Boolean) this.f2279a.i.get()).booleanValue(), null), CallerContext.b(getClass(), "AuthOperations"));
    }
}
