package com.facebook.katana.server.handler;

import android.content.Context;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticateMethod;
import com.facebook.auth.protocol.AuthenticateMethod.Params;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: transfers */
public class AuthenticateCredentialsHandler implements BlueServiceHandler {
    private static AuthenticateCredentialsHandler f1157d;
    private static final Object f1158e = new Object();
    public final Provider<SingleMethodRunner> f1159a;
    public final AuthenticateMethod f1160b;
    public final String f1161c;

    private static AuthenticateCredentialsHandler m1186b(InjectorLike injectorLike) {
        return new AuthenticateCredentialsHandler((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), AuthenticateMethod.b(injectorLike));
    }

    @Inject
    public AuthenticateCredentialsHandler(FbSharedPreferences fbSharedPreferences, Provider<SingleMethodRunner> provider, AuthenticateMethod authenticateMethod) {
        this.f1159a = provider;
        this.f1160b = authenticateMethod;
        this.f1161c = fbSharedPreferences.a(AuthPrefKeys.f, null);
    }

    public final OperationResult m1187a(OperationParams operationParams) {
        ((AbstractSingleMethodRunner) this.f1159a.get()).a(this.f1160b, new Params((PasswordCredentials) operationParams.c.getParcelable("passwordCredentials"), this.f1161c, null, false, null));
        return OperationResult.a;
    }

    public static AuthenticateCredentialsHandler m1185a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AuthenticateCredentialsHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1158e) {
                AuthenticateCredentialsHandler authenticateCredentialsHandler;
                if (a2 != null) {
                    authenticateCredentialsHandler = (AuthenticateCredentialsHandler) a2.a(f1158e);
                } else {
                    authenticateCredentialsHandler = f1157d;
                }
                if (authenticateCredentialsHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1186b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1158e, b3);
                        } else {
                            f1157d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = authenticateCredentialsHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
