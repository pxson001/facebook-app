package com.facebook.messaging.media.download;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

/* compiled from: mInvites */
public class BlueServiceHandler_MediaDownloadQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f11510a;
    private static final Object f11511b = new Object();

    private static BlueServiceHandler m12167b(InjectorLike injectorLike) {
        return MediaDownloadServiceHandler.m12196b(injectorLike);
    }

    public Object get() {
        return MediaDownloadServiceHandler.m12196b((InjectorLike) this);
    }

    public static BlueServiceHandler m12166a(InjectorLike injectorLike) {
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
            synchronized (f11511b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f11511b);
                } else {
                    blueServiceHandler = f11510a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12167b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11511b, b3);
                        } else {
                            f11510a = b3;
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
