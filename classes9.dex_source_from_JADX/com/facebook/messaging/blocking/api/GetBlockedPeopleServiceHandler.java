package com.facebook.messaging.blocking.api;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: onError */
public class GetBlockedPeopleServiceHandler implements BlueServiceHandler {
    private static GetBlockedPeopleServiceHandler f8305c;
    private static final Object f8306d = new Object();
    private final Provider<SingleMethodRunner> f8307a;
    private final GetBlockedPeopleMethod f8308b;

    private static GetBlockedPeopleServiceHandler m8559b(InjectorLike injectorLike) {
        return new GetBlockedPeopleServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new GetBlockedPeopleMethod((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public GetBlockedPeopleServiceHandler(Provider<SingleMethodRunner> provider, GetBlockedPeopleMethod getBlockedPeopleMethod) {
        this.f8307a = provider;
        this.f8308b = getBlockedPeopleMethod;
    }

    public final OperationResult m8560a(OperationParams operationParams) {
        String str = operationParams.b;
        Assertions.a("GetBlockedPeople".equals(str), "Unknown type " + str);
        return OperationResult.a((ArrayList) ((AbstractSingleMethodRunner) this.f8307a.get()).a(this.f8308b, null, CallerContext.a(GetBlockedPeopleServiceHandler.class)));
    }

    public static GetBlockedPeopleServiceHandler m8558a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GetBlockedPeopleServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8306d) {
                GetBlockedPeopleServiceHandler getBlockedPeopleServiceHandler;
                if (a2 != null) {
                    getBlockedPeopleServiceHandler = (GetBlockedPeopleServiceHandler) a2.a(f8306d);
                } else {
                    getBlockedPeopleServiceHandler = f8305c;
                }
                if (getBlockedPeopleServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8559b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8306d, b3);
                        } else {
                            f8305c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = getBlockedPeopleServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
