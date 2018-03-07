package com.facebook.notifications.module;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.notifications.protocol.NotificationsServiceHandler;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHandler;

/* compiled from: messenger_media_upload_request_in_progress */
public class BlueServiceHandler_NotificationsQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f7950a;
    private static final Object f7951b = new Object();

    private static BlueServiceHandler m8280b(InjectorLike injectorLike) {
        return NotificationsModule.m7929a(GraphQLNotificationsContentProviderHandler.m8282b(injectorLike), NotificationsServiceHandler.m8286b(injectorLike));
    }

    public Object get() {
        return NotificationsModule.m7929a(GraphQLNotificationsContentProviderHandler.m8282b(this), NotificationsServiceHandler.m8286b(this));
    }

    public static BlueServiceHandler m8279a(InjectorLike injectorLike) {
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
            synchronized (f7951b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f7951b);
                } else {
                    blueServiceHandler = f7950a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8280b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7951b, b3);
                        } else {
                            f7950a = b3;
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
