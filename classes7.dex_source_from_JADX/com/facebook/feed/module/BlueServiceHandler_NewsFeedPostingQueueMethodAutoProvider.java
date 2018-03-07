package com.facebook.feed.module;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

/* compiled from: alignItems */
public class BlueServiceHandler_NewsFeedPostingQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f19540a;
    private static final Object f19541b = new Object();

    private static BlueServiceHandler m22853b(InjectorLike injectorLike) {
        return BlueServiceHandler_ForNewsfeedMethodAutoProvider.b(injectorLike);
    }

    public Object get() {
        return BlueServiceHandler_ForNewsfeedMethodAutoProvider.b(this);
    }

    public static BlueServiceHandler m22852a(InjectorLike injectorLike) {
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
            synchronized (f19541b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f19541b);
                } else {
                    blueServiceHandler = f19540a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22853b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19541b, b3);
                        } else {
                            f19540a = b3;
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
