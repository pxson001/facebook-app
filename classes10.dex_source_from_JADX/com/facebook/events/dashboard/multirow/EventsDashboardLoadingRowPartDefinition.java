package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: com.facebook.sdk.ApplicationName */
public class EventsDashboardLoadingRowPartDefinition extends MultiRowSinglePartDefinition<Object, Void, AnyEnvironment, View> {
    public static final ViewType f17073a = new C23951();
    private static EventsDashboardLoadingRowPartDefinition f17074b;
    private static final Object f17075c = new Object();

    /* compiled from: com.facebook.sdk.ApplicationName */
    final class C23951 extends ViewType {
        C23951() {
        }

        public final View m17380a(Context context) {
            return LayoutInflater.from(context).inflate(2130904041, null);
        }
    }

    private static EventsDashboardLoadingRowPartDefinition m17382b() {
        return new EventsDashboardLoadingRowPartDefinition();
    }

    public final boolean m17384a(Object obj) {
        return obj == EventsDashboardItemCollection.f17052a;
    }

    public final ViewType<View> m17383a() {
        return f17073a;
    }

    public static EventsDashboardLoadingRowPartDefinition m17381a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardLoadingRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17075c) {
                EventsDashboardLoadingRowPartDefinition eventsDashboardLoadingRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardLoadingRowPartDefinition = (EventsDashboardLoadingRowPartDefinition) a2.a(f17075c);
                } else {
                    eventsDashboardLoadingRowPartDefinition = f17074b;
                }
                if (eventsDashboardLoadingRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m17382b();
                        if (a2 != null) {
                            a2.a(f17075c, b3);
                        } else {
                            f17074b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardLoadingRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
