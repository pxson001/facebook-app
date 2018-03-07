package com.facebook.events.connectionqe;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: operation already running */
public class EventsConnectionExperimentController {
    private static EventsConnectionExperimentController f6066a;
    private static final Object f6067b = new Object();

    private static EventsConnectionExperimentController m6529c() {
        return new EventsConnectionExperimentController();
    }

    public static ImmutableList<EventsConnectionStyleExperiment$PublicEventAction> m6528b() {
        return ImmutableList.of(EventsConnectionStyleExperiment$PublicEventAction.WATCH_INTERESTED, EventsConnectionStyleExperiment$PublicEventAction.GOING, EventsConnectionStyleExperiment$PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE);
    }

    public static EventsConnectionExperimentController m6527a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsConnectionExperimentController c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6067b) {
                EventsConnectionExperimentController eventsConnectionExperimentController;
                if (a2 != null) {
                    eventsConnectionExperimentController = (EventsConnectionExperimentController) a2.a(f6067b);
                } else {
                    eventsConnectionExperimentController = f6066a;
                }
                if (eventsConnectionExperimentController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m6529c();
                        if (a2 != null) {
                            a2.a(f6067b, c);
                        } else {
                            f6066a = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = eventsConnectionExperimentController;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
