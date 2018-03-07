package com.facebook.events.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: commerce_storefront_limage_adapter */
public class EventsDashboardController {
    private static EventsDashboardController f16566f;
    private static final Object f16567g = new Object();
    public FbFragment f16568a;
    public LoaderCallbacks<Cursor> f16569b;
    public DashboardFilterType f16570c = DashboardFilterType.UPCOMING;
    public EventsPager f16571d;
    public boolean f16572e;

    private static EventsDashboardController m16977d() {
        return new EventsDashboardController();
    }

    public final void m16978a() {
        if (!this.f16572e && m16976c()) {
            this.f16568a.E().a(this.f16570c.ordinal(), null, this.f16569b);
            this.f16572e = true;
        }
    }

    public final void m16979a(DashboardFilterType dashboardFilterType) {
        if (m16976c()) {
            if (this.f16571d != null) {
                this.f16571d.m17278a();
            }
            if (dashboardFilterType != this.f16570c) {
                if (this.f16570c != DashboardFilterType.BIRTHDAYS) {
                    this.f16568a.E().a(this.f16570c.ordinal());
                }
                this.f16570c = dashboardFilterType;
                if (dashboardFilterType != DashboardFilterType.BIRTHDAYS) {
                    this.f16568a.E().b(dashboardFilterType.ordinal(), null, this.f16569b);
                }
            }
        }
    }

    public static EventsDashboardController m16975a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardController d;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16567g) {
                EventsDashboardController eventsDashboardController;
                if (a2 != null) {
                    eventsDashboardController = (EventsDashboardController) a2.a(f16567g);
                } else {
                    eventsDashboardController = f16566f;
                }
                if (eventsDashboardController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        d = m16977d();
                        if (a2 != null) {
                            a2.a(f16567g, d);
                        } else {
                            f16566f = d;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    d = eventsDashboardController;
                }
            }
            return d;
        } finally {
            a.c(b);
        }
    }

    private boolean m16976c() {
        return (this.f16568a.x || !this.f16568a.mx_() || this.f16568a.L) ? false : true;
    }
}
