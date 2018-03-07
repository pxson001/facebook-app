package com.facebook.commerce.productdetails.api;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
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
/* compiled from: deleteThreads */
public class ProductDetailsServiceHandler implements BlueServiceHandler {
    private static ProductDetailsServiceHandler f15137c;
    private static final Object f15138d = new Object();
    private Lazy<SingleMethodRunner> f15139a;
    private final Lazy<SubmitItemForCheckoutMethod> f15140b;

    private static ProductDetailsServiceHandler m15665b(InjectorLike injectorLike) {
        return new ProductDetailsServiceHandler(IdBasedLazy.a(injectorLike, 5066), IdBasedSingletonScopeProvider.b(injectorLike, 2289));
    }

    @Inject
    public ProductDetailsServiceHandler(Lazy<SubmitItemForCheckoutMethod> lazy, Lazy<SingleMethodRunner> lazy2) {
        this.f15140b = lazy;
        this.f15139a = lazy2;
    }

    public final OperationResult m15666a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("submit_item_for_checkout".equals(str)) {
            return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f15139a.get()).a((ApiMethod) this.f15140b.get(), (CheckoutParams) bundle.getParcelable("checkoutParams")));
        }
        throw new ApiMethodNotFoundException(str);
    }

    public static ProductDetailsServiceHandler m15664a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProductDetailsServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15138d) {
                ProductDetailsServiceHandler productDetailsServiceHandler;
                if (a2 != null) {
                    productDetailsServiceHandler = (ProductDetailsServiceHandler) a2.a(f15138d);
                } else {
                    productDetailsServiceHandler = f15137c;
                }
                if (productDetailsServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15665b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15138d, b3);
                        } else {
                            f15137c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = productDetailsServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
