package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardRowView;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironment;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGenerated;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPermalinkController;
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
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN */
public class EventsDashboardEventRowPartDefinition extends MultiRowSinglePartDefinition<Event, State, EventsDashboardEnvironment, EventsDashboardRowView> {
    public static final ViewType f17045a = ViewType.a(2130904142);
    private static EventsDashboardEventRowPartDefinition f17046c;
    private static final Object f17047d = new Object();
    public final EventPermalinkController f17048b;

    /* compiled from: com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN */
    public class State {
        final /* synthetic */ EventsDashboardEventRowPartDefinition f17043a;
        public final OnClickListener f17044b;

        public State(EventsDashboardEventRowPartDefinition eventsDashboardEventRowPartDefinition, OnClickListener onClickListener) {
            this.f17043a = eventsDashboardEventRowPartDefinition;
            this.f17044b = onClickListener;
        }
    }

    private static EventsDashboardEventRowPartDefinition m17352b(InjectorLike injectorLike) {
        return new EventsDashboardEventRowPartDefinition(EventPermalinkController.m18262b(injectorLike));
    }

    public final Object m17354a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final EventAnalyticsParams s = ((EventsDashboardEnvironmentGenerated) anyEnvironment).mo794s();
        return new State(this, new OnClickListener(this) {
            final /* synthetic */ EventsDashboardEventRowPartDefinition f17042b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1813428325);
                EventsDashboardRowView eventsDashboardRowView = (EventsDashboardRowView) view;
                if (eventsDashboardRowView.f16754m == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 372636527, a);
                    return;
                }
                this.f17042b.f17048b.m18266a(view.getContext(), eventsDashboardRowView.f16754m, s.b);
                LogUtils.a(1614218045, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m17355a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -650713054);
        State state = (State) obj2;
        EventsDashboardEnvironmentGenerated eventsDashboardEnvironmentGenerated = (EventsDashboardEnvironmentGenerated) anyEnvironment;
        EventsDashboardRowView eventsDashboardRowView = (EventsDashboardRowView) view;
        eventsDashboardRowView.m17146a((Event) obj, false, eventsDashboardEnvironmentGenerated.mo794s(), eventsDashboardEnvironmentGenerated.mo795t(), false, true);
        eventsDashboardRowView.setOnClickListener(state.f17044b);
        Logger.a(8, EntryType.MARK_POP, 1061413921, a);
    }

    public final void m17357b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((EventsDashboardRowView) view).setOnClickListener(null);
    }

    @Inject
    public EventsDashboardEventRowPartDefinition(EventPermalinkController eventPermalinkController) {
        this.f17048b = eventPermalinkController;
    }

    public final boolean m17356a(Object obj) {
        return true;
    }

    public final ViewType<EventsDashboardRowView> m17353a() {
        return f17045a;
    }

    public static EventsDashboardEventRowPartDefinition m17351a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardEventRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17047d) {
                EventsDashboardEventRowPartDefinition eventsDashboardEventRowPartDefinition;
                if (a2 != null) {
                    eventsDashboardEventRowPartDefinition = (EventsDashboardEventRowPartDefinition) a2.a(f17047d);
                } else {
                    eventsDashboardEventRowPartDefinition = f17046c;
                }
                if (eventsDashboardEventRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17352b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17047d, b3);
                        } else {
                            f17046c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardEventRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
