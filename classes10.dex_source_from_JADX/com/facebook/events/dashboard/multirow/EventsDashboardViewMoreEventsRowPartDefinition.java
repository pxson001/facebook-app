package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironment;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGenerated;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: com.facebook.rtc.fbwebrtc.CALL_LOG_UPDATED */
public class EventsDashboardViewMoreEventsRowPartDefinition extends MultiRowSinglePartDefinition<Object, OnClickListener, EventsDashboardEnvironment, View> {
    public static final ViewType f17103a = ViewType.a(2130904144);
    private static EventsDashboardViewMoreEventsRowPartDefinition f17104b;
    private static final Object f17105c = new Object();

    private static EventsDashboardViewMoreEventsRowPartDefinition m17412b() {
        return new EventsDashboardViewMoreEventsRowPartDefinition();
    }

    public final Object m17414a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final EventsDashboardEnvironmentGenerated eventsDashboardEnvironmentGenerated = (EventsDashboardEnvironmentGenerated) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ EventsDashboardViewMoreEventsRowPartDefinition f17102b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 810563945);
                eventsDashboardEnvironmentGenerated.mo793c(true);
                eventsDashboardEnvironmentGenerated.hL_();
                Logger.a(2, EntryType.UI_INPUT_END, -1364787668, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m17415a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2070425247);
        view.setOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, -1270552087, a);
    }

    public final boolean m17416a(Object obj) {
        return obj == EventsDashboardItemCollection.f17053b;
    }

    public final ViewType<View> m17413a() {
        return f17103a;
    }

    public static EventsDashboardViewMoreEventsRowPartDefinition m17411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardViewMoreEventsRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17105c) {
                EventsDashboardViewMoreEventsRowPartDefinition eventsDashboardViewMoreEventsRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardViewMoreEventsRowPartDefinition = (EventsDashboardViewMoreEventsRowPartDefinition) a2.a(f17105c);
                } else {
                    eventsDashboardViewMoreEventsRowPartDefinition = f17104b;
                }
                if (eventsDashboardViewMoreEventsRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m17412b();
                        if (a2 != null) {
                            a2.a(f17105c, b3);
                        } else {
                            f17104b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardViewMoreEventsRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m17417b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
