package com.facebook.languages.switcher.service;

import android.content.Context;
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
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: time_between_waking_network_ms */
public class LanguageSwitcherServiceHandler implements BlueServiceHandler {
    private static LanguageSwitcherServiceHandler f1422c;
    private static final Object f1423d = new Object();
    public final Provider<SingleMethodRunner> f1424a;
    public GetUserLocaleMethod f1425b;

    private static LanguageSwitcherServiceHandler m1424b(InjectorLike injectorLike) {
        return new LanguageSwitcherServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), GetUserLocaleMethod.m1420a(injectorLike));
    }

    @Inject
    public LanguageSwitcherServiceHandler(Provider<SingleMethodRunner> provider, GetUserLocaleMethod getUserLocaleMethod) {
        this.f1424a = provider;
        this.f1425b = getUserLocaleMethod;
    }

    public final OperationResult m1425a(OperationParams operationParams) {
        if ("switcher_get_locale".equals(operationParams.b)) {
            return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f1424a.get()).a(this.f1425b, operationParams.c.getString("getLocale")));
        }
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    public static LanguageSwitcherServiceHandler m1423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LanguageSwitcherServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1423d) {
                LanguageSwitcherServiceHandler languageSwitcherServiceHandler;
                if (a2 != null) {
                    languageSwitcherServiceHandler = (LanguageSwitcherServiceHandler) a2.a(f1423d);
                } else {
                    languageSwitcherServiceHandler = f1422c;
                }
                if (languageSwitcherServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1423d, b3);
                        } else {
                            f1422c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = languageSwitcherServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
