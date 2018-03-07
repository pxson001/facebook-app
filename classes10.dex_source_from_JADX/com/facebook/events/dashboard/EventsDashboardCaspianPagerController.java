package com.facebook.events.dashboard;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: commerce_ui_detail_sections */
public class EventsDashboardCaspianPagerController {
    private static EventsDashboardCaspianPagerController f16562c;
    private static final Object f16563d = new Object();
    private final QeAccessor f16564a;
    public boolean f16565b;

    private static EventsDashboardCaspianPagerController m16973b(InjectorLike injectorLike) {
        return new EventsDashboardCaspianPagerController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventsDashboardCaspianPagerController(QeAccessor qeAccessor) {
        this.f16564a = qeAccessor;
    }

    public final boolean m16974a() {
        return this.f16565b || this.f16564a.a(ExperimentsForEventsGatingModule.x, false);
    }

    public static EventsDashboardCaspianPagerController m16972a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardCaspianPagerController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16563d) {
                EventsDashboardCaspianPagerController eventsDashboardCaspianPagerController;
                if (a2 != null) {
                    eventsDashboardCaspianPagerController = (EventsDashboardCaspianPagerController) a2.a(f16563d);
                } else {
                    eventsDashboardCaspianPagerController = f16562c;
                }
                if (eventsDashboardCaspianPagerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16973b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16563d, b3);
                        } else {
                            f16562c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventsDashboardCaspianPagerController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
