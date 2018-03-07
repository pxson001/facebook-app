package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.events.dashboard.EventsDashboardNoEventsRowView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: com.facebook.sdk.ApplicationId */
public class EventsDashboardNullStateRowPartDefinition extends MultiRowSinglePartDefinition<DashboardFilterType, Void, AnyEnvironment, EventsDashboardNoEventsRowView> {
    public static final ViewType f17076a = new C23961();
    private static EventsDashboardNullStateRowPartDefinition f17077b;
    private static final Object f17078c = new Object();

    /* compiled from: com.facebook.sdk.ApplicationId */
    final class C23961 extends ViewType {
        C23961() {
        }

        public final View m17385a(Context context) {
            return new EventsDashboardNoEventsRowView(context);
        }
    }

    private static EventsDashboardNullStateRowPartDefinition m17387b() {
        return new EventsDashboardNullStateRowPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m17389a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2015980690);
        ((EventsDashboardNoEventsRowView) view).m17083a((DashboardFilterType) obj);
        Logger.a(8, EntryType.MARK_POP, 377472302, a);
    }

    public final boolean m17390a(Object obj) {
        return ((DashboardFilterType) obj) != null;
    }

    public final ViewType<EventsDashboardNoEventsRowView> m17388a() {
        return f17076a;
    }

    public static EventsDashboardNullStateRowPartDefinition m17386a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardNullStateRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17078c) {
                EventsDashboardNullStateRowPartDefinition eventsDashboardNullStateRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardNullStateRowPartDefinition = (EventsDashboardNullStateRowPartDefinition) a2.a(f17078c);
                } else {
                    eventsDashboardNullStateRowPartDefinition = f17077b;
                }
                if (eventsDashboardNullStateRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m17387b();
                        if (a2 != null) {
                            a2.a(f17078c, b3);
                        } else {
                            f17077b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardNullStateRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
