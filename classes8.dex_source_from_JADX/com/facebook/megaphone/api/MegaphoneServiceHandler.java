package com.facebook.megaphone.api;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
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
/* compiled from: typeahead_mode */
public class MegaphoneServiceHandler implements BlueServiceHandler {
    private static MegaphoneServiceHandler f1281c;
    private static final Object f1282d = new Object();
    public final Provider<SingleMethodRunner> f1283a;
    public final LogMegaphoneMethod f1284b;

    private static MegaphoneServiceHandler m1515b(InjectorLike injectorLike) {
        return new MegaphoneServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new LogMegaphoneMethod());
    }

    @Inject
    public MegaphoneServiceHandler(Provider<SingleMethodRunner> provider, LogMegaphoneMethod logMegaphoneMethod) {
        this.f1283a = provider;
        this.f1284b = logMegaphoneMethod;
    }

    public final OperationResult m1516a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("log_megaphone".equals(str)) {
            ((AbstractSingleMethodRunner) this.f1283a.get()).a(this.f1284b, (LogMegaphoneParams) operationParams.c.getParcelable("logMegaphoneParams"));
            return OperationResult.a;
        }
        throw new ApiMethodNotFoundException(str);
    }

    public static MegaphoneServiceHandler m1514a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MegaphoneServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1282d) {
                MegaphoneServiceHandler megaphoneServiceHandler;
                if (a2 != null) {
                    megaphoneServiceHandler = (MegaphoneServiceHandler) a2.a(f1282d);
                } else {
                    megaphoneServiceHandler = f1281c;
                }
                if (megaphoneServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1515b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1282d, b3);
                        } else {
                            f1281c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = megaphoneServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
