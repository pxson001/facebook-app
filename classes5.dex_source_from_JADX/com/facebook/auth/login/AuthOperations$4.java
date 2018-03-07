package com.facebook.auth.login;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.CreateMessengerAccountCredentials;
import com.facebook.auth.protocol.CreateMessengerAccountParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import java.util.concurrent.Callable;

/* compiled from: tagbox */
class AuthOperations$4 implements Callable<AuthenticationResult> {
    final /* synthetic */ CreateMessengerAccountCredentials f2272a;
    final /* synthetic */ boolean f2273b;
    final /* synthetic */ String f2274c;
    final /* synthetic */ AuthOperations f2275d;

    AuthOperations$4(AuthOperations authOperations, CreateMessengerAccountCredentials createMessengerAccountCredentials, boolean z, String str) {
        this.f2275d = authOperations;
        this.f2272a = createMessengerAccountCredentials;
        this.f2273b = z;
        this.f2274c = str;
    }

    public Object call() {
        return (AuthenticationResult) ((AbstractSingleMethodRunner) this.f2275d.f.get()).a(this.f2275d.k, new CreateMessengerAccountParams(this.f2272a, ((Boolean) this.f2275d.i.get()).booleanValue(), this.f2273b, this.f2274c, this.f2275d.b.a(AuthPrefKeys.f, null)), CallerContext.b(getClass(), "AuthOperations"));
    }
}
