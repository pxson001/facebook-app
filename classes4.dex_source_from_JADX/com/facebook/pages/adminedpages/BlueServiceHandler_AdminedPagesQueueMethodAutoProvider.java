package com.facebook.pages.adminedpages;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.adminedpages.service.AdminedPagesCacheServiceHandler;
import com.facebook.pages.adminedpages.service.AdminedPagesDbServiceHandler;
import com.facebook.pages.adminedpages.service.AdminedPagesWebServiceHandler;

/* compiled from: error_code */
public class BlueServiceHandler_AdminedPagesQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f12812a;
    private static final Object f12813b = new Object();

    private static BlueServiceHandler m13654b(InjectorLike injectorLike) {
        return AdminedPagesModule.m13119a(AdminedPagesCacheServiceHandler.m13657b(injectorLike), AdminedPagesDbServiceHandler.m13659b(injectorLike), AdminedPagesWebServiceHandler.m13669b(injectorLike));
    }

    public Object get() {
        return AdminedPagesModule.m13119a(AdminedPagesCacheServiceHandler.m13657b(this), AdminedPagesDbServiceHandler.m13659b(this), AdminedPagesWebServiceHandler.m13669b(this));
    }

    public static BlueServiceHandler m13653a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlueServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12813b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f12813b);
                } else {
                    blueServiceHandler = f12812a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13654b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12813b, b3);
                        } else {
                            f12812a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blueServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
