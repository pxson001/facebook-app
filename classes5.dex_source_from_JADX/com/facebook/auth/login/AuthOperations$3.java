package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.WorkUserSwitchCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.WorkAccountSwitchMethod$Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$3 implements Callable<AuthenticationResult> {
    final /* synthetic */ WorkUserSwitchCredentials f2270a;
    final /* synthetic */ AuthOperations f2271b;

    AuthOperations$3(AuthOperations authOperations, WorkUserSwitchCredentials workUserSwitchCredentials) {
        this.f2271b = authOperations;
        this.f2270a = workUserSwitchCredentials;
    }

    public Object call() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2271b.f.get()).a(this.f2271b.n, new WorkAccountSwitchMethod$Params(this.f2270a, this.f2271b.b.a(AuthPrefKeys.f, null), null, ((Boolean) this.f2271b.i.get()).booleanValue(), null), CallerContext.b(getClass(), "AuthOperations"));
    }
}
