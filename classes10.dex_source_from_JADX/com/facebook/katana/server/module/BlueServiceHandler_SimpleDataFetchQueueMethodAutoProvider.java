package com.facebook.katana.server.module;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.server.handler.FacewebComponentsStoreHandler;

/* compiled from: touch */
public class BlueServiceHandler_SimpleDataFetchQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f1169a;
    private static final Object f1170b = new Object();

    private static BlueServiceHandler m1194b(InjectorLike injectorLike) {
        return Fb4aServiceModule.a(FacewebComponentsStoreHandler.m1188b(injectorLike));
    }

    public Object get() {
        return Fb4aServiceModule.a(FacewebComponentsStoreHandler.m1188b(this));
    }

    public static BlueServiceHandler m1193a(InjectorLike injectorLike) {
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
            synchronized (f1170b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f1170b);
                } else {
                    blueServiceHandler = f1169a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1194b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1170b, b3);
                        } else {
                            f1169a = b3;
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
