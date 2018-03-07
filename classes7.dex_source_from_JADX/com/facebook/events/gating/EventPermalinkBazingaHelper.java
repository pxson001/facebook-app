package com.facebook.events.gating;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: callJavaModuleMethod */
public class EventPermalinkBazingaHelper {
    private static EventPermalinkBazingaHelper f17898a;
    private static final Object f17899b = new Object();

    private static EventPermalinkBazingaHelper m21748c() {
        return new EventPermalinkBazingaHelper();
    }

    public static boolean m21747a(GraphQLConnectionStyle graphQLConnectionStyle) {
        return graphQLConnectionStyle == GraphQLConnectionStyle.INTERESTED;
    }

    public static EventPermalinkBazingaHelper m21746a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventPermalinkBazingaHelper c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17899b) {
                EventPermalinkBazingaHelper eventPermalinkBazingaHelper;
                if (a2 != null) {
                    eventPermalinkBazingaHelper = (EventPermalinkBazingaHelper) a2.a(f17899b);
                } else {
                    eventPermalinkBazingaHelper = f17898a;
                }
                if (eventPermalinkBazingaHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m21748c();
                        if (a2 != null) {
                            a2.a(f17899b, c);
                        } else {
                            f17898a = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = eventPermalinkBazingaHelper;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
