package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticateMethod.Params;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$2 implements Callable<AuthenticationResult> {
    final /* synthetic */ String f2267a;
    final /* synthetic */ String f2268b;
    final /* synthetic */ AuthOperations f2269c;

    AuthOperations$2(AuthOperations authOperations, String str, String str2) {
        this.f2269c = authOperations;
        this.f2267a = str;
        this.f2268b = str2;
    }

    public Object call() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2269c.f.get()).a(this.f2269c.d, new Params(new PasswordCredentials(this.f2267a, this.f2268b, Type.WORK_REGISTRATION_AUTOLOGIN_NONCE), this.f2269c.b.a(AuthPrefKeys.f, null), null, ((Boolean) this.f2269c.i.get()).booleanValue(), null), CallerContext.b(getClass(), "AuthOperations"));
    }
}
