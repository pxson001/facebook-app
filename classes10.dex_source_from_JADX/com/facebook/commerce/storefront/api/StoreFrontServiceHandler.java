package com.facebook.commerce.storefront.api;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: createEventResult */
public class StoreFrontServiceHandler implements BlueServiceHandler {
    private static final CallerContext f15698a = CallerContext.a(StoreFrontServiceHandler.class);
    private static StoreFrontServiceHandler f15699d;
    private static final Object f15700e = new Object();
    private Lazy<SingleMethodRunner> f15701b;
    private final Lazy<MerchantSubscriptionStatusUpdateMethod> f15702c;

    private static StoreFrontServiceHandler m16147b(InjectorLike injectorLike) {
        return new StoreFrontServiceHandler(IdBasedLazy.a(injectorLike, 5091), IdBasedSingletonScopeProvider.b(injectorLike, 2289));
    }

    @Inject
    public StoreFrontServiceHandler(Lazy<MerchantSubscriptionStatusUpdateMethod> lazy, Lazy<SingleMethodRunner> lazy2) {
        this.f15702c = lazy;
        this.f15701b = lazy2;
    }

    public final OperationResult m16148a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("update_merchant_subscription_status".equals(str)) {
            AbstractSingleMethodRunner abstractSingleMethodRunner = (AbstractSingleMethodRunner) this.f15701b.get();
            if (bundle == null) {
                return OperationResult.a(ErrorCode.valueOf("Null Parameters"));
            }
            return OperationResult.a((String) abstractSingleMethodRunner.a((ApiMethod) this.f15702c.get(), (MerchantSubscriptionParams) bundle.getParcelable("merchantSubscriptionParams"), f15698a));
        }
        throw new ApiMethodNotFoundException(str);
    }

    public static StoreFrontServiceHandler m16146a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoreFrontServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15700e) {
                StoreFrontServiceHandler storeFrontServiceHandler;
                if (a2 != null) {
                    storeFrontServiceHandler = (StoreFrontServiceHandler) a2.a(f15700e);
                } else {
                    storeFrontServiceHandler = f15699d;
                }
                if (storeFrontServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16147b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15700e, b3);
                        } else {
                            f15699d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storeFrontServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
