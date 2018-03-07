package com.facebook.timeline.aboutpage;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.aboutpage.service.CollectionsCacheServiceHandler;

/* compiled from: NO_DATA */
public class BlueServiceHandler_TimelineCollectionsQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f12995a;
    private static final Object f12996b = new Object();

    private static BlueServiceHandler m13737b(InjectorLike injectorLike) {
        return TimelineCollectionsModule.m13830a(CollectionsCacheServiceHandler.m14777a(injectorLike), C1554x9c5d308f.m13834b(injectorLike));
    }

    public Object get() {
        return TimelineCollectionsModule.m13830a(CollectionsCacheServiceHandler.m14777a(this), C1554x9c5d308f.m13834b(this));
    }

    public static BlueServiceHandler m13736a(InjectorLike injectorLike) {
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
            synchronized (f12996b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f12996b);
                } else {
                    blueServiceHandler = f12995a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13737b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12996b, b3);
                        } else {
                            f12995a = b3;
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
